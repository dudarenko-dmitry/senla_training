package pl.senla.hotel.dao;

import org.reflections.Reflections;
import pl.senla.hotel.connection.AbstractConnection;
import pl.senla.hotel.utils.DataBaseMapperUtil;

import java.lang.reflect.*;
import java.sql.*;
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
//            setFieldsValuesToUpdateInstance(t, stmt);
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
                .toList();
        for (Field f : fields) {
            f.setAccessible(true);
            String fieldName = f.getName();
            Class<?> fieldType = f.getType();
            if (fieldType.isEnum()) {
                Enum anEnum = Enum.valueOf((Class<? extends Enum>) fieldType, rs.getString(fieldName));
                f.set(t, anEnum);
            } else if (fieldType.equals(Integer.class)) {
                f.set(t, rs.getInt(mappingEntityToDB.get(fieldName)));
            } else if (fieldType.equals(String.class)) {
                f.set(t, rs.getString(mappingEntityToDB.get(fieldName)));
            } else if (fieldType.equals(Timestamp.class)) {
                f.set(t, rs.getTimestamp(mappingEntityToDB.get(fieldName)));
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
            Field field = null;
            try {
                field = aClass.getDeclaredField(fieldName);
                setValuesToStatement(t, stmt, field, j, getter);
                j++;
            } catch (NoSuchFieldException e) {
                Class<?> superClass = aClass.getSuperclass();
                try {
                    field = superClass.getDeclaredField(fieldName);
                    setValuesToStatement(t, stmt, field, j, getter);
                    j++;
                } catch (NoSuchFieldException ex) {
                    Reflections reflections = new Reflections("pl.senla.hotel.entity");
                    List<Class<?>> childClasses = (List<Class<?>>) reflections.getSubTypesOf(aClass).stream().toList();
                    Class<?> childClass = childClasses.stream()
                            .filter(cl -> {
                                try {
                                    return cl.getDeclaredField(fieldName) != null;
                                } catch (NoSuchFieldException exc) {
                                    throw new RuntimeException(exc);
                                }
                            })
                            .findFirst().orElse(null);
                    try {
                        assert childClass != null;
                        field = childClass.getDeclaredField(fieldName);
                        setValuesToStatement(t, stmt, field, j, getter);
                    } catch (NoSuchFieldException | NoSuchMethodException exc) {
                        throw new RuntimeException(exc);
                    }
                } catch (NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    private void setFieldsValuesToUpdateInstance(T t, PreparedStatement stmt) throws SQLException,
//            InvocationTargetException, IllegalAccessException  {
//        int j = 1;
//        for (int i = 2; i < entitiesFields.size(); i++) {
//            String fieldName = entitiesFields.get(i);
//            String getterStringCommand = getGetterString(fieldName);
//            Method getter = getGetter(t, getterStringCommand);
//            Field field;
//            try {
//                field = t.getClass().getDeclaredField(fieldName);
//                setValuesToStatement(t, stmt, field, j, getter);
//            } catch (NoSuchFieldException e) {
//                Class<?> superclass = t.getClass().getSuperclass();
//                try {
//                    field = superclass.getDeclaredField(fieldName);
//                    setValuesToStatement(t, stmt, field, j, getter);
//                    j++;
//                } catch (NoSuchFieldException ex) {
//                    Class<?> aClass = Arrays.stream(t.getClass().getClasses())
//                            .filter(cl -> {
//                                try {
//                                    return cl.getDeclaredField(fieldName) != null;
//                                } catch (NoSuchFieldException exc) {
//                                    throw new RuntimeException(exc);
//                                }
//                            })
//                            .findFirst().orElse(null);
//                    try {
//                        assert aClass != null;
//                        field = aClass.getDeclaredField(fieldName);
//                        setValuesToStatement(t, stmt, field, j, getter);
//                    } catch (NoSuchFieldException exc) {
//                        throw new RuntimeException(exc);
//                    }
//                }
//            }
//            j++;
//        }
//    }

    private static <T> void setValuesToStatement(T t, PreparedStatement stmt, Field field, int j, Method getter)
            throws SQLException, NoSuchMethodException {
        Class<?> fieldType = field.getType();
        Class<?> aClass = t.getClass();
        field.setAccessible(true);
        if (fieldType.isEnum()) {
            try {
                stmt.setString(j, String.valueOf(getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                try {
                    Class<?> childClass = getChildClassByField(field, aClass);
                    Object childInstance = childClass.getConstructor().newInstance();
                    stmt.setString(j, String.valueOf(getter.invoke(childInstance)));
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (fieldType.equals(Integer.class)) {
            try {
                stmt.setInt(j, (Integer) getter.invoke(t));
            } catch (IllegalAccessException | InvocationTargetException e) {
                try {
                    Class<?> childClass = getChildClassByField(field, aClass);
                    Object childInstance = childClass.getConstructor().newInstance();
                    stmt.setInt(j, (Integer) getter.invoke(childInstance));
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (fieldType.equals(String.class)) {
            try {
                stmt.setString(j, String.valueOf(getter.invoke(t)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                try {
                    Class<?> childClass = getChildClassByField(field, aClass);
                    Object childInstance = childClass.getConstructor().newInstance();
                    stmt.setString(j, String.valueOf(getter.invoke(childInstance)));
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (fieldType.equals(Timestamp.class)) {
            try {
                stmt.setTimestamp(j, (Timestamp) getter.invoke(t));
            } catch (IllegalAccessException | InvocationTargetException e) {
                try {
                    Class<?> childClass = getChildClassByField(field, aClass);
                    Object childInstance = childClass.getConstructor().newInstance();
                    stmt.setTimestamp(j, (Timestamp) getter.invoke(childInstance));
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else {
            System.out.println("No such type of fields in Application. " + fieldType +
                    "\nNew type must be added to Application.");
        }
    }

    private static Class<?> getChildClassByField(Field field, Class<?> aClass) {
        Reflections reflections = new Reflections("pl.senla.hotel.entity");
        List<Class<?>> childClasses = (List<Class<?>>) reflections.getSubTypesOf(aClass).stream().toList();
        return childClasses.stream().filter(cl -> {
                    try {
                        return cl.getDeclaredField(String.valueOf(field)) != null;
                    } catch (NoSuchFieldException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .findAny().orElse(null);
    }

    private static <T> Method getGetter(T t, String fieldGetter) {
        Class<?> aClass = t.getClass();
        Method getter = null;
        try {
            getter = t.getClass().getDeclaredMethod(fieldGetter);
        } catch (NoSuchMethodException e) {
            Class<?> superClass = aClass.getSuperclass();
            try {
                getter = superClass.getDeclaredMethod(fieldGetter);
            } catch (NoSuchMethodException e1) {
                Reflections reflections = new Reflections("pl.senla.hotel.entity");
                List<Class<?>> childClasses = (List<Class<?>>) reflections.getSubTypesOf(aClass).stream().toList();
                Class<?> childClass = childClasses.stream()
                        .filter(cl -> {
                            try {
                                return cl.getDeclaredMethod(fieldGetter) != null;
                            } catch (NoSuchMethodException e2) {
                                throw new RuntimeException(e2);
                            }
                        })
                        .findAny().orElse(null);
                try {
                    assert childClass != null;
                    getter = childClass.getDeclaredMethod(fieldGetter);
                } catch (NoSuchMethodException exc) {
                    throw new RuntimeException(exc);
                }
            }
        }
        return getter;
    }

    private static String getGetterString(String fieldName) {
        String fieldGetter = "get" +
                fieldName.substring(0,1).toUpperCase() +
                fieldName.substring(1);
        return fieldGetter;
    }

}
