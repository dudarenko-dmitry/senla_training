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
import static pl.senla.hotel.constant.DaoConstant.*;

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
        log.debug(CREATE_GENERIC_DAO, type);
    }

    @Override
    public List<T> readAll() {
        log.debug(START_METHOD_READ_ALL);
        Connection connection = null;
        ArrayList<T> list = new ArrayList<>();
        try {
            connection = AbstractConnection.connection();
            log.debug(DB_CONNECTED);
            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_FIELDS +
                    mappingEntityToDB.get(TABLE_NAME));
            ResultSet rs = stmt.executeQuery();
            log.debug(GET_RESULT_SET);
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
        log.debug(START_METHOD_CREATE);
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            log.debug(DB_CONNECTED);
            String command = getStringBuilderCreateInstance();
            PreparedStatement stmt = connection.prepareStatement(command);
            setFieldsValuesToPreparedStatement(t, stmt);
            log.debug(EXECUTE_REQUEST_TO_DB);
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
        log.debug(START_METHOD_READ);
        T instance = null;
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            log.debug(DB_CONNECTED);
            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_FIELDS +
                    mappingEntityToDB.get(TABLE_NAME) + WHERE + tablesFields.get(1) + // edit
                    REQUEST_VALUE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            log.debug(GET_RESULT_SET);
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
        log.debug(START_METHOD_UPDATE);
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            log.debug(DB_CONNECTED);
            String command = getStringBuilderUpdateInstance(id);
            PreparedStatement stmt = connection.prepareStatement(command);
            setFieldsValuesToPreparedStatement(t, stmt);
            log.debug(EXECUTE_REQUEST_TO_DB);
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
        log.debug(START_METHOD_DELETE);
        Connection connection = null;
        try {
            connection = AbstractConnection.connection();
            log.debug(DB_CONNECTED);
            PreparedStatement stmt = connection.prepareStatement(DELETE_FROM + mappingEntityToDB.get(TABLE_NAME) +
                    WHERE + tablesFields.get(1) +
                    REQUEST_VALUE);
            stmt.setInt(1, id);
            log.debug(EXECUTE_REQUEST_TO_DB);
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
            InstantiationException, SQLException, IllegalAccessException {
        log.debug(START_METHOD_GET_ENTITY);
        T t = type.getConstructor().newInstance();
        Field[] declaredFields = type.getDeclaredFields();
        List<Field> fields = Arrays.stream(declaredFields)
                .filter(f -> !f.getName().equals("serialVersionUID"))
                .filter(f -> !f.getType().isInterface())
                .toList();
        log.debug(GET_FIELDS);
        for (Field f : fields) {
            f.setAccessible(true);
            String fieldName = f.getName();
            Class<?> fieldType = f.getType();
            if (fieldType.isEnum()) {
                Enum anEnum = Enum.valueOf((Class<? extends Enum>) fieldType,
                        rs.getString(mappingEntityToDB.get(fieldName)));
                log.debug(SET_VALUE_ENUM);
                f.set(t, anEnum);
            } else if (fieldType.equals(Integer.class)) {
                log.debug(SET_VALUE_INTEGER);
                f.set(t, rs.getInt(mappingEntityToDB.get(fieldName)));
            } else if (fieldType.equals(String.class)) {
                log.debug(SET_VALUE_STRING);
                f.set(t, rs.getString(mappingEntityToDB.get(fieldName)));
            } else if (fieldType.equals(LocalDateTime.class)) {
                log.debug(SET_VALUE_TIMESTAMP);
                Timestamp timestamp = rs.getTimestamp(mappingEntityToDB.get(fieldName));
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                f.set(t, localDateTime);
            } else {
                log.warn(WARN_ADD_NEW_METHOD,
                        fieldType);
            }
        }
        return t;
    }

    private String getStringBuilderCreateInstance() {
        log.debug(START_METHOD_BUILD_STRING_TO_CREATE);
        StringBuilder command = new StringBuilder();
        command.append(INSERT_INTO).append(mappingEntityToDB.get(TABLE_NAME)).append(" (");
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
        log.debug(START_METHOD_BUILD_STRING_TO_UPDATE);
        StringBuilder command = new StringBuilder();
        command.append(UPDATE).append(mappingEntityToDB.get(TABLE_NAME)).append(SET);
        int size = tablesFields.size();
        if (size == 3) { // №0 - tableName, №1 - ID
            command.append(tablesFields.get(2)).append(REQUEST_VALUE);
        } else {
            for (int i = 2; i < size - 1; i++) {
                command.append(tablesFields.get(i)).append(REQUEST_VALUE).append(", ");
            }
            command.append(tablesFields.get(size - 1)).append(REQUEST_VALUE);
        }
        command.append(WHERE).append(tablesFields.get(1)).append("=").append(id);
        return command.toString();
    }

    private void setFieldsValuesToPreparedStatement(T t, PreparedStatement stmt) throws SQLException {
        log.debug(START_METHOD_SET_FIELD_VALUES_TO_STATEMENT);
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
            } catch (NoSuchFieldException e) {
                log.error(ERROR_METHOD_SET_FIELD_VALUES_TO_STATEMENT, new RuntimeException(e));
            }
        }
    }

    private static <T> void setValuesToStatement(T t, PreparedStatement stmt, Field field, int j, Method getter)
            throws SQLException {
        Class<?> fieldType = field.getType();
        field.setAccessible(true);
        if (fieldType.isEnum()) {
            try {
                stmt.setString(j, String.valueOf(getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(ERROR_METHOD_SET_VALUES_TO_STATEMENT, new RuntimeException(e));
            }
        } else if (fieldType.equals(Integer.class)) {
            try {
                stmt.setInt(j, (Integer) getter.invoke(t));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(ERROR_METHOD_SET_VALUES_TO_STATEMENT, new RuntimeException(e));
            }
        } else if (fieldType.equals(String.class)) {
            try {
                stmt.setString(j, String.valueOf(getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(ERROR_METHOD_SET_VALUES_TO_STATEMENT, new RuntimeException(e));
            }
        } else if (fieldType.equals(LocalDateTime.class)) {
            try {
                stmt.setTimestamp(j, Timestamp.valueOf((LocalDateTime) getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(ERROR_METHOD_SET_VALUES_TO_STATEMENT, new RuntimeException(e));
            }
        } else {
            log.warn(WARN_ADD_NEW_METHOD, fieldType);
        }
    }

    private static <T> Method getGetter(T t, String fieldGetter) {
        log.debug(START_METHOD_GET_GETTER);
        try {
            return t.getClass().getDeclaredMethod(fieldGetter);
        } catch (NoSuchMethodException e) {
            log.error(ERROR_METHOD_GET_GETTER, new RuntimeException(e));
            return null;
        }
    }

    private static String getGetterString(String fieldName) {
        return "get" +
                fieldName.substring(0,1).toUpperCase() +
                fieldName.substring(1);
    }

}
