package pl.senla.hotel.connection;

import pl.senla.hotel.utils.DBPropertiesUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static pl.senla.hotel.constant.DBConstant.*;

public abstract class AbstractConnection {

    private final static String URL = "db.url";
    private final static String USERNAME = "db.username";
    private final static String PASSWORD = "db.password";
    private static Connection connection = null;

    public static Connection connection() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            Driver driver = new com.mysql.cj.jdbc.Driver();
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(
                        DBPropertiesUtil.get(URL),
                        DBPropertiesUtil.get(USERNAME),
                        DBPropertiesUtil.get(PASSWORD));
                System.out.println(DB_CONNECTED);
            }
            return connection;
        } catch (SQLException e) {
            System.out.println(DB_CONNECTION_ERROR);
            throw new SQLException(DB_CONNECTION_ERROR, e);
        }
    }

    public static void close() {
        if(connection != null){
            try {
                connection.close();
                connection = null;
                System.out.println(DB_CONNECTION_CLOSE);
            } catch (SQLException e) {
                System.out.println(DB_CONNECTION_CLOSE_ERROR);
                throw new RuntimeException(e);
            }
        }
    }
}
