package pl.senla.hotel.configuration;

import java.io.*;
import java.util.Properties;

import static pl.senla.hotel.constant.InputOutputConstant.*;
import static pl.senla.hotel.constant.PropertiesConstant.*;

public class AppPropertiesLoader implements PropertiesLoader {

    Properties appProperties = new Properties();
    File propertiesFile = new File("C://IT/senla_training/src/pl/senla/hotel/resources/hotel.properties");

    @Override
    public Properties loadConfiguration() {
        try (FileInputStream fis = new FileInputStream(propertiesFile)) {
            appProperties.load(fis);
            appProperties.put(KEY_ABLE_TO_CHANGE_ROOM_STATUS,
                    appProperties.getProperty(KEY_ABLE_TO_CHANGE_ROOM_STATUS));
            appProperties.put(KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM,
                    appProperties.getProperty(KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM));
            appProperties.put(KEY_FILE_PATH,
                    appProperties.getProperty(KEY_FILE_PATH));
            appProperties.put(KEY_FILE_PATH_SERIALIZABLE,
                    appProperties.getProperty(KEY_FILE_PATH_SERIALIZABLE));
            appProperties.put(KEY_FILE_SERIALIZABLE_NAME,
                    appProperties.getProperty(KEY_FILE_SERIALIZABLE_NAME));
            appProperties.put(KEY_FILE_HOTEL_FACILITIES_NAME,
                    appProperties.getProperty(KEY_FILE_HOTEL_FACILITIES_NAME));
            appProperties.put(KEY_FILE_GUESTS_NAME,
                    appProperties.getProperty(KEY_FILE_GUESTS_NAME));
            appProperties.put(KEY_FILE_HOTEL_SERVICES_NAME,
                    appProperties.getProperty(KEY_FILE_HOTEL_SERVICES_NAME));
            appProperties.put(KEY_FILE_ORDERS_NAME,
                    appProperties.getProperty(KEY_FILE_ORDERS_NAME));
        } catch (FileNotFoundException e) {
            System.out.println(ERROR_GET_PROPERTIES_FILE);
        } catch (IOException e) {
            System.out.println(ERROR_READ_PROPERTIES_FILE);
        }
        return appProperties;
    }

    /**
     * delete after first creating of properties' file
     * Later change configuration via file hotel.properties
     */
    @Override
    public void saveConfiguration() {
        try (FileOutputStream fos = new FileOutputStream(propertiesFile)) {
            appProperties.setProperty(KEY_ABLE_TO_CHANGE_ROOM_STATUS, "TRUE");
            appProperties.setProperty(KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM, "10");
            appProperties.setProperty(KEY_FILE_PATH, "C://IT/Data/");
            appProperties.setProperty(KEY_FILE_PATH_SERIALIZABLE, "C://IT/Serialization/");
            appProperties.setProperty(KEY_FILE_SERIALIZABLE_NAME, "hotel.ser");
            appProperties.setProperty(KEY_FILE_HOTEL_FACILITIES_NAME, "HotelFacility.csv");
            appProperties.setProperty(KEY_FILE_GUESTS_NAME, "Guests.csv");
            appProperties.setProperty(KEY_FILE_HOTEL_SERVICES_NAME, "HotelServices.csv");
            appProperties.setProperty(KEY_FILE_ORDERS_NAME, "Orders.csv");
            appProperties.store(fos, null);
        } catch (FileNotFoundException e) {
            System.out.println(ERROR_GET_PROPERTIES_FILE);
        } catch (IOException e) {
            System.out.println(ERROR_WRITE_PROPERTIES_FILE);
        }
    }

}
