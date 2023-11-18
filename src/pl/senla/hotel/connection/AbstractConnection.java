package pl.senla.hotel.connection;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.utils.DBPropertiesUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static pl.senla.hotel.constant.DBConstant.*;
@Slf4j
public abstract class AbstractConnection {

    private final static String URL = "db.url";
    private final static String USERNAME = "db.username";
    private final static String PASSWORD = "db.password";
    private static Connection connection = null;

    public static Connection connection() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        log.debug("Start of Create connection");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(
                        DBPropertiesUtil.get(URL),
                        DBPropertiesUtil.get(USERNAME),
                        DBPropertiesUtil.get(PASSWORD));
                log.info(DB_CONNECTED);
            }
            return connection;
        } catch (SQLException e) {
            log.error(DB_CONNECTION_ERROR);
            throw new SQLException(DB_CONNECTION_ERROR, e);
        }
    }

    public static void close() {
        log.debug("Start of Close connection");
        if(connection != null){
            try {
                connection.close();
                connection = null;
                log.info(DB_CONNECTION_CLOSE);
            } catch (SQLException e) {
                log.error(DB_CONNECTION_CLOSE_ERROR);
                throw new RuntimeException(e);
            }
        }
    }
}
