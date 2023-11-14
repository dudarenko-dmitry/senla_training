package pl.senla.hotel.dao;

import pl.senla.hotel.connection.AbstractConnection;
import pl.senla.hotel.utils.DataBaseMapperUtil;

import java.lang.reflect.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static pl.senla.hotel.constant.DBConstant.DB_CONNECTION_CLOSE_ERROR;
import static pl.senla.hotel.constant.DBConstant.DB_CONNECTION_ERROR;

public abstract class GenericDaoDB<T> implements GenericDao<T> {

    private final Class<T> type;
    private final LinkedHashMap<String, String> mappingEntityToDB;
    private final List<String> entitiesFields;
    private final List<String> tablesFields;

    public GenericDaoDB() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
        mappingEntityToDB = (LinkedHashMap<String, String>) DataBaseMapperUtil.getMapper(type);
        entitiesFields = mappingEntityToDB.keySet().stream().toList();
        tablesFields = mappingEntityToDB.values().stream().toList();
    }

    @Override
    public List<T> readAll() {
        Connection connection = null;
        ArrayList<T> list = new ArrayList<>();
        try {
            connection = AbstractConnection.connection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " +
                    mappingEntityToDB.get("tableName"));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                T t = getEntity(rs);
                list.add(t);
            }
        } catch (SQLException | InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            System.out.println(DB_CONNECTION_ERROR);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(DB_CONNECTION_CLOSE_ERROR + "\n" + e);
            }
        }
        return list;
    }

    @Override
    public boolean create(T t) {
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            String command = getStringBuilderCreateInstance();
            PreparedStatement stmt = connection.prepareStatement(command);
            setFieldsValuesToCreateInstance(t, stmt);
            return stmt.execute();
        } catch (SQLException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(DB_CONNECTION_ERROR);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | InstantiationException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(DB_CONNECTION_CLOSE_ERROR + "\n" + e);
            }
        }
    }

    @Override
    public T read(int id) {
        T instance = null;
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " +
                    mappingEntityToDB.get("tableName") + " WHERE " + tablesFields.get(1) + // edit
                    " =?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                instance = getEntity(rs);
            }
        } catch (SQLException | NoSuchMethodException | InvocationTargetException |
                 InstantiationException | IllegalAccessException e) {
            System.out.println(DB_CONNECTION_ERROR);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(DB_CONNECTION_CLOSE_ERROR + "\n" + e);
            }
        }
        return instance;
    }

    @Override
    public boolean update(int id, T t) {
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            String command = getStringBuilderUpdateInstance(id);
            PreparedStatement stmt = connection.prepareStatement(command);
            setFieldsValuesToCreateInstance(t, stmt);
            return stmt.execute();
        } catch (SQLException e) {
            System.out.println(DB_CONNECTION_ERROR);
            throw new RuntimeException(e);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                 InstantiationException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(DB_CONNECTION_CLOSE_ERROR + "\n" + e);
            }
        }
    }

    @Override
    public boolean delete(int id) {
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM " + mappingEntityToDB.get("tableName") +
                    " WHERE " + tablesFields.get(1) + // edit
                    " =?");
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (SQLException e) {
            System.out.println(DB_CONNECTION_ERROR);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(DB_CONNECTION_CLOSE_ERROR + "\n" + e);
            }
        }
    }

    private T getEntity(ResultSet rs) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
        T t = type.getConstructor().newInstance();
        Field[] declaredFields = type.getDeclaredFields();
        List<Field> fields = Arrays.stream(declaredFields)
                .filter(f -> !f.getName().equals("serialVersionUID"))
                .filter(f -> !f.getType().isInterface())
                .toList();
        for (Field f : fields) {
            f.setAccessible(true);
            String fieldName = f.getName();
            Class<?> fieldType = f.getType();
            if (fieldType.isEnum()) {
                Enum anEnum = Enum.valueOf((Class<? extends Enum>) fieldType,
                        rs.getString(mappingEntityToDB.get(fieldName)));
                f.set(t, anEnum);
            } else if (fieldType.equals(Integer.class)) {
                f.set(t, rs.getInt(mappingEntityToDB.get(fieldName)));
            } else if (fieldType.equals(String.class)) {
                f.set(t, rs.getString(mappingEntityToDB.get(fieldName)));
            } else if (fieldType.equals(LocalDateTime.class)) {
                Timestamp timestamp = rs.getTimestamp(mappingEntityToDB.get(fieldName));
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                f.set(t, localDateTime);

            } else {
                System.out.println("No such type of fields in Application. " + fieldType +
                        "\nNew type must be added to Application.");
            }
        }
        return t;
    }

    private String getStringBuilderCreateInstance() {
        StringBuilder command = new StringBuilder("");
        command.append("INSERT INTO ").append(mappingEntityToDB.get("tableName")).append(" (");
        int size = tablesFields.size(); // edit
        if (size == 3) {  // №1 - tableName, №2 - ID parameter
            command.append(tablesFields.get(2))
                    .append(") VALUE (?)");
        } else {
            for (int i = 2; i < size - 1; i++) {
                command.append(tablesFields.get(i)).append(", ");
            }
            command.append(tablesFields.get(size - 1)).append(") VALUE (");
            for (int i = 2; i <= size - 2; i++) {
                command.append("?").append(", ");
            }
            command.append("?)");
        }
        return command.toString();
    }

    private String getStringBuilderUpdateInstance(int id) {
        StringBuilder command = new StringBuilder("" );
        command.append("UPDATE ").append(mappingEntityToDB.get("tableName")).append(" SET ");
        int size = tablesFields.size();
        if (size == 3) { // №0 - tableName, №1 - ID
            command.append(tablesFields.get(2)).append("=?");
        } else {
            for (int i = 2; i < size - 1; i++) {
                command.append(tablesFields.get(i)).append("=?").append(", ");
            }
            command.append(tablesFields.get(size - 1)).append("=?");
        }
        command.append(" WHERE ").append(tablesFields.get(1)).append("=").append(id);
        return command.toString();
    }

    private void setFieldsValuesToCreateInstance(T t, PreparedStatement stmt) throws SQLException,
            IllegalAccessException, InvocationTargetException {
        int j = 1;
        for (int i = 2; i < entitiesFields.size(); i++) {
            Class<?> aClass = t.getClass();
            String fieldName = entitiesFields.get(i);
            String getterStringCommand = getGetterString(fieldName);
            Method getter = getGetter(t, getterStringCommand);
            try {
                Field field = aClass.getDeclaredField(fieldName);
                setValuesToStatement(t, stmt, field, j, getter);
                j++;
            } catch (NoSuchFieldException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static <T> void setValuesToStatement(T t, PreparedStatement stmt, Field field, int j, Method getter)
            throws SQLException, NoSuchMethodException {
        Class<?> fieldType = field.getType();
        Class<?> aClass = t.getClass();
        field.setAccessible(true);
        if (fieldType.isEnum()) {
            try {
                stmt.setString(j, String.valueOf(getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } else if (fieldType.equals(Integer.class)) {
            try {
                stmt.setInt(j, (Integer) getter.invoke(t));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } else if (fieldType.equals(String.class)) {
            try {
                stmt.setString(j, String.valueOf(getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } else if (fieldType.equals(LocalDateTime.class)) {
            try {
                stmt.setTimestamp(j, Timestamp.valueOf((LocalDateTime) getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No such type of fields in Application. " + fieldType +
                    "\nNew type must be added to Application.");
        }
    }

    private static <T> Method getGetter(T t, String fieldGetter) {
        try {
            return t.getClass().getDeclaredMethod(fieldGetter);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getGetterString(String fieldName) {
        return "get" +
                fieldName.substring(0,1).toUpperCase() +
                fieldName.substring(1);
    }

}
