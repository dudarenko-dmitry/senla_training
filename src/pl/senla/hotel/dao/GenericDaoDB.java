package pl.senla.hotel.dao;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.connection.AbstractConnection;
import pl.senla.hotel.utils.DataBaseMapperUtil;

import java.lang.reflect.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static pl.senla.hotel.constant.DBConstant.*;

@Slf4j
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
        log.info("Created GenericDaoDB for {}", type);
    }

    @Override
    public List<T> readAll() {
        log.debug("Start GenericDaoDB method 'ReadAll'");
        Connection connection = null;
        ArrayList<T> list = new ArrayList<>();
        try {
            connection = AbstractConnection.connection();
            log.debug("Get connection to DB");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " +
                    mappingEntityToDB.get("tableName"));
            ResultSet rs = stmt.executeQuery();
            log.debug("Get ResultSet and start process it.");
            while (rs.next()) {
                T t = getEntity(rs);
                list.add(t);
            }
        } catch (SQLException | InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | ClassNotFoundException e) {
            log.error(DB_CONNECTION_ERROR, new RuntimeException(e));
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    log.info(DB_CONNECTION_CLOSE);
                }
            } catch (SQLException e) {
                log.error(DB_CONNECTION_CLOSE_ERROR, e);
            }
        }
        return list;
    }

    @Override
    public boolean create(T t) {
        log.debug("Start GenericDaoDB method 'Create'");
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            log.debug("Get connection to DB");
            String command = getStringBuilderCreateInstance();
            PreparedStatement stmt = connection.prepareStatement(command);
            setFieldsValuesToCreateInstance(t, stmt);
            log.debug("Execute Request to DB.");
            return stmt.execute();
        } catch (SQLException | IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                 ClassNotFoundException | InstantiationException e) {
            log.error(DB_CONNECTION_ERROR, new RuntimeException(e));
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    log.info(DB_CONNECTION_CLOSE);
                }
            } catch (SQLException e) {
                log.error(DB_CONNECTION_CLOSE_ERROR, e);
            }
        }
        return false;
    }

    @Override
    public T read(int id) {
        log.debug("Start GenericDaoDB method 'Read'");
        T instance = null;
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            log.debug("Get connection to DB");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " +
                    mappingEntityToDB.get("tableName") + " WHERE " + tablesFields.get(1) + // edit
                    " =?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            log.debug("Get ResultSet and start process it.");
            while (rs.next()) {
                instance = getEntity(rs);
            }
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException | ClassNotFoundException e) {
            log.error(DB_CONNECTION_ERROR, new RuntimeException(e));
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    log.info(DB_CONNECTION_CLOSE);
                }
            } catch (SQLException e) {
                log.error(DB_CONNECTION_CLOSE_ERROR, e);
            }
        }
        return instance;
    }

    @Override
    public boolean update(int id, T t) {
        log.debug("Start GenericDaoDB method 'Update'");
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            log.debug("Get connection to DB");
            String command = getStringBuilderUpdateInstance(id);
            PreparedStatement stmt = connection.prepareStatement(command);
            setFieldsValuesToCreateInstance(t, stmt);
            log.debug("Execute Request to DB.");
            return stmt.execute();
        } catch (SQLException e) {
            System.out.println(DB_CONNECTION_ERROR);
            log.error(DB_CONNECTION_ERROR, new RuntimeException(e));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                 InstantiationException | ClassNotFoundException e) {
            log.error(DB_CONNECTION_ERROR, new RuntimeException(e));
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    log.info(DB_CONNECTION_CLOSE);
                }
            } catch (SQLException e) {
                log.error(DB_CONNECTION_CLOSE_ERROR, e);
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        log.debug("Start GenericDaoDB method 'Delete'");
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            log.debug("Get connection to DB");
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM " + mappingEntityToDB.get("tableName") +
                    " WHERE " + tablesFields.get(1) + // edit
                    " =?");
            stmt.setInt(1, id);
            log.debug("Execute Request to DB.");
            return stmt.execute();
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException e) {
            log.error(DB_CONNECTION_ERROR, new RuntimeException(e));
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    log.info(DB_CONNECTION_CLOSE);
                }
            } catch (SQLException e) {
                log.error(DB_CONNECTION_CLOSE_ERROR, e);
            }
        }
        return false;
    }

    private T getEntity(ResultSet rs) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
        log.debug("Get instance from ResultSet.");
        T t = type.getConstructor().newInstance();
        Field[] declaredFields = type.getDeclaredFields();
        List<Field> fields = Arrays.stream(declaredFields)
                .filter(f -> !f.getName().equals("serialVersionUID"))
                .filter(f -> !f.getType().isInterface())
                .toList();
        log.debug("Get instance's fields.");
        for (Field f : fields) {
            f.setAccessible(true);
            String fieldName = f.getName();
            Class<?> fieldType = f.getType();
            if (fieldType.isEnum()) {
                Enum anEnum = Enum.valueOf((Class<? extends Enum>) fieldType,
                        rs.getString(mappingEntityToDB.get(fieldName)));
                log.debug("Set Enum value to field.");
                f.set(t, anEnum);
            } else if (fieldType.equals(Integer.class)) {
                log.debug("Set Integer value to field.");
                f.set(t, rs.getInt(mappingEntityToDB.get(fieldName)));
            } else if (fieldType.equals(String.class)) {
                log.debug("Set String value to field.");
                f.set(t, rs.getString(mappingEntityToDB.get(fieldName)));
            } else if (fieldType.equals(LocalDateTime.class)) {
                log.debug("Set Timestamp value to field.");
                Timestamp timestamp = rs.getTimestamp(mappingEntityToDB.get(fieldName));
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                f.set(t, localDateTime);
            } else {
                log.error("No such type of fields in Application {}.\nNew type must be added to Application.",
                        fieldType);
            }
        }
        return t;
    }

    private String getStringBuilderCreateInstance() {
        log.debug("Create PreparedStatement for CreateInstance.");
        StringBuilder command = new StringBuilder();
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
        log.debug("Create PreparedStatement for UpdateInstance.");
        StringBuilder command = new StringBuilder();
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
        log.debug("Set values in setFieldsValuesToCreateInstance.");
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
                log.error("ERROR in setFieldsValuesToCreateInstance.", new RuntimeException(e));
            }
        }
    }

    private static <T> void setValuesToStatement(T t, PreparedStatement stmt, Field field, int j, Method getter)
            throws SQLException, NoSuchMethodException {
        Class<?> fieldType = field.getType();
        field.setAccessible(true);
        if (fieldType.isEnum()) {
            try {
                stmt.setString(j, String.valueOf(getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error("ERROR in setValuesToStatement.", new RuntimeException(e));
            }
        } else if (fieldType.equals(Integer.class)) {
            try {
                stmt.setInt(j, (Integer) getter.invoke(t));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error("ERROR in setValuesToStatement.", new RuntimeException(e));
            }
        } else if (fieldType.equals(String.class)) {
            try {
                stmt.setString(j, String.valueOf(getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error("ERROR in setValuesToStatement.", new RuntimeException(e));
            }
        } else if (fieldType.equals(LocalDateTime.class)) {
            try {
                stmt.setTimestamp(j, Timestamp.valueOf((LocalDateTime) getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error("ERROR in setValuesToStatement.", new RuntimeException(e));
            }
        } else {
            log.error("No such type of fields in Application: {}.\nNew type must be added to Application.", fieldType);
        }
    }

    private static <T> Method getGetter(T t, String fieldGetter) {
        try {
            return t.getClass().getDeclaredMethod(fieldGetter);
        } catch (NoSuchMethodException e) {
            log.error("ERROR in getGetter.", new RuntimeException(e));
            return null;
        }
    }

    private static String getGetterString(String fieldName) {
        return "get" +
                fieldName.substring(0,1).toUpperCase() +
                fieldName.substring(1);
    }

}
