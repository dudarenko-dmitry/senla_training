package pl.senla.hotel.connection;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.ConfigProperty;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static pl.senla.hotel.constant.DBConstant.DB_CONNECTED;
import static pl.senla.hotel.constant.DBConstant.DB_CONNECTION_ERROR;

@AppComponent
public class AbstractConnection {

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "db.url")
    private static String url;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "db.username")
    private static String username;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "db.password")
    private static String password;
    private static Connection connection = null;

    public static Connection connection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            if (connection == null) {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println(DB_CONNECTED);
            }
            return connection;
        } catch (SQLException e) {
            System.out.println(DB_CONNECTION_ERROR);
            throw new SQLException(DB_CONNECTION_ERROR, e);
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close() throws SQLException {
        if(connection != null){
            connection.close();
            connection = null;
        }
    }
}
