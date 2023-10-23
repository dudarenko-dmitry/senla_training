//package pl.senla.hotel.configuration;
//
//import java.io.*;
//import java.util.Properties;
//
//import static pl.senla.hotel.constant.InputOutputConstant.*;
//
//public class AppPropertiesLoader implements PropertiesLoader {
//
//    private final Properties appProperties;
//    private final File propertiesFile;
//
//    public AppPropertiesLoader() {
//        appProperties = new Properties();
//        propertiesFile = new File("C://IT/senla_training/src/pl/senla/hotel/resources/hotel.properties");
//    }
//
//    @Override
//    public Properties loadConfiguration() {
//        try (FileInputStream fis = new FileInputStream(propertiesFile)) {
//            appProperties.load(fis);
//        } catch (FileNotFoundException e) {
//            System.out.println(ERROR_GET_PROPERTIES_FILE);
//        } catch (IOException e) {
//            System.out.println(ERROR_READ_PROPERTIES_FILE);
//        }
//        return appProperties;
//    }
//
//}
