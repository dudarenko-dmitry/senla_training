//package pl.senla.hotel.utils;
//
//import pl.senla.hotel.application.config.AppConfiguration;
//import pl.senla.hotel.application.config.Configuration;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public final class DBPropertiesUtil {
//
//    private static final Properties PROPERTIES_DB = new Properties();
//    private static final Configuration configuration = new AppConfiguration();
//    private static final String configDirectory = configuration.getPropertiesDirectory();
//    private static final String configFile = configuration.getDBPropertiesFileName();
//
//    private DBPropertiesUtil(){
//    }
//
//    static {
//        loadProperties();
//    }
//
//    public static String get(String key){
//        return PROPERTIES_DB.getProperty(key);
//    }
//
//    private static void loadProperties() {
//        try(FileInputStream fis = new FileInputStream(new File(configDirectory, configFile))) {
//            PROPERTIES_DB.load(fis);
//        } catch (IOException e) {
//            throw new RuntimeException("System hasn't read property-file", e);
//        }
//    }
//
//    private Properties loadProperty(String configDirectory, String configName) {
//        Properties properties = new Properties();
//        try (FileInputStream fis = new FileInputStream(new File(configDirectory, configName))) {
//            properties.load(fis);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return properties;
//    }
//}
