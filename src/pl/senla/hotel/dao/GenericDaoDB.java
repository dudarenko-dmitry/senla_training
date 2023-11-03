package pl.senla.hotel.dao;

import pl.senla.hotel.connection.AbstractConnection;
import pl.senla.hotel.utils.DataBaseMapperUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GenericDaoDB<T> implements GenericDao<T> {

    private final Class<T> type;
    private final HashMap<String, String> mappingEntityToDB;

    public GenericDaoDB() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
        mappingEntityToDB = (HashMap<String, String>) DataBaseMapperUtil.getMapper(type);
    }

    @Override
    public List<T> readAll() {
        Connection connection = null;
        List<Class<T>> list = new ArrayList<>();
        try {
            connection = AbstractConnection.connection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " +
                    mappingEntityToDB.get("tableName"));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                T t = (T) getEntity(rs);
                list.add((Class<T>) t);
            }
        } catch (SQLException | InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            AbstractConnection.close();
        }
        return (List<T>) list;
    }

    @Override
    public boolean create(T t) {
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            List<String> entitiesFields = mappingEntityToDB.keySet().stream().toList();
            String command = getStringBuilderCreateT(entitiesFields);
            PreparedStatement stmt = connection.prepareStatement(command);
            int j = 1;
            for (int i = 2; i < entitiesFields.size(); i++) {
                String fieldName = entitiesFields.get(i);
                String fieldGetter = "t.get" +
                        fieldName.substring(0,0).toUpperCase() +
                        fieldName.substring(1);
                Field field = t.getClass().getDeclaredField(fieldName);
                Class<?> fieldClass = field.getDeclaringClass();
                field.setAccessible(true);
                if (field.isEnumConstant()) {
                    stmt.setString(j, String.valueOf(t.getClass().getDeclaredMethod(fieldGetter).invoke(t))); // check !!!
                } else if (fieldClass.equals("Integer")) {
                    stmt.setInt(j, (Integer) t.getClass().getDeclaredMethod(fieldGetter).invoke(t));
                } else if (fieldClass.equals("String")) {
                    stmt.setString(j, String.valueOf(t.getClass().getDeclaredMethod(fieldGetter).invoke(t))); // check !!!
                } else if (fieldClass.equals("Timestamp")) {
                    stmt.setTimestamp(j, (Timestamp) t.getClass().getDeclaredMethod(fieldGetter).invoke(t));
                } else {
                    System.out.println("No such type of fields in Application. New type must be added to Application.");
                }
            }
            return stmt.execute();
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        } finally {
            AbstractConnection.close();
        }
    }

    @Override
    public T read(int id) {

        return (T) new Object();
    }

    @Override
    public boolean update(int id, T t) {

        return true;
    }

    @Override
    public boolean delete(int id) {

        return true;
    }

    private T getEntity(ResultSet rs) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, SQLException {
        T t = type.getConstructor().newInstance();
        Field[] declaredFields = type.getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            String fieldName = f.getName();
            Class<?> fieldClass = f.getDeclaringClass();
            String command = "";
            if (f.isEnumConstant()) {
                command = fieldClass + ".valueOf(" + rs + ".getString(" + mappingEntityToDB.get(fieldName) + "))";
                f.set(t, command);
            } else if (f.getDeclaringClass().equals("Integer")) {
                f.set(t, rs.getInt(mappingEntityToDB.get(fieldName)));
            } else if (f.getDeclaringClass().equals("String")) {
                f.set(t, rs.getString(mappingEntityToDB.get(fieldName)));
            } else if (fieldClass.equals("Timestamp")) {
                f.set(t, rs.getTimestamp(mappingEntityToDB.get(fieldName)));
            } else {
                System.out.println("No such type of fields in Application. New type must be added to Application.");
            }
        }
        return t;
    }

    private String getStringBuilderCreateT(List<String> entitiesFields) {
        StringBuilder command = new StringBuilder();
        command.append("INSERT INTO ").append(mappingEntityToDB.get("tableName")).append(" (");
        int size = entitiesFields.size();
        if (size > 3) { // №0 - tableName, №1 - ID
            for (int i = 2; i < size - 1; i++) {
                command.append(mappingEntityToDB.get(i)).append(", ");
            }
            command.append(mappingEntityToDB.get(size)).append(") VALUES (");
            for (int i = 2; i < size - 1; i++) {
                command.append("?").append(", ");
            }
            command.append("?)");
        } else {
            command.append(mappingEntityToDB.get(1))
                    .append(") VALUE (?)");
        }
        return command.toString();
    }

}
