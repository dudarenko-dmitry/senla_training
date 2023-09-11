package pl.senla.hotel.configuration;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static pl.senla.hotel.configuration.AppConfiguration.*;
import static pl.senla.hotel.constant.InputOutputConstant.*;

public class AppPropertiesLoader implements PropertiesLoader {

    Properties appProperties = new Properties();
    File propertiesFile = new File("C://IT/Properties/hotel.properties");

    @Override
    public Map<String, String> loadConfiguration() {
        Map<String, String> configuration = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(propertiesFile)) {
            appProperties.load(fis);
            configuration.put(KEY_ABLE_TO_CHANGE_ROOM_STATUS,
                    appProperties.getProperty(KEY_ABLE_TO_CHANGE_ROOM_STATUS));
            configuration.put(KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM,
                    appProperties.getProperty(KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM));
            configuration.put(KEY_FILE_PATH,
                    appProperties.getProperty(KEY_FILE_PATH));
            configuration.put(KEY_FILE_HOTEL_FACILITIES_NAME,
                    appProperties.getProperty(KEY_FILE_HOTEL_FACILITIES_NAME));
            configuration.put(KEY_FILE_GUESTS_NAME,
                    appProperties.getProperty(KEY_FILE_GUESTS_NAME));
            configuration.put(KEY_FILE_HOTEL_SERVICES_NAME,
                    appProperties.getProperty(KEY_FILE_HOTEL_SERVICES_NAME));
            configuration.put(KEY_FILE_ORDERS_NAME,
                    appProperties.getProperty(KEY_FILE_ORDERS_NAME));
        } catch (FileNotFoundException e) {
            System.out.println(ERROR_GET_PROPERTIES_FILE);
        } catch (IOException e) {
            System.out.println(ERROR_READ_PROPERTIES_FILE);
        }
        return configuration;
    }

    /**
     * delete after first creating of properties' file
     * Later change configuration via file hotel.properties

    @Override
    public void saveConfiguration() {
        try (FileOutputStream fos = new FileOutputStream(propertiesFile)) {
            appProperties.put(KEY_ABLE_TO_CHANGE_ROOM_STATUS, "TRUE");
            appProperties.put(KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM, "10");
            appProperties.put(KEY_FILE_PATH, "C://IT/Data/");
            appProperties.put(KEY_FILE_HOTEL_FACILITIES_NAME, "HotelFacility.csv");
            appProperties.put(KEY_FILE_GUESTS_NAME, "Guests.csv");
            appProperties.put(KEY_FILE_HOTEL_SERVICES_NAME, "HotelServices.csv");
            appProperties.put(KEY_FILE_ORDERS_NAME, "Orders.csv");
            appProperties.store(fos, "");
        } catch (FileNotFoundException e) {
            System.out.println(ERROR_GET_PROPERTIES_FILE);
        } catch (IOException e) {
            System.out.println(ERROR_WRITE_PROPERTIES_FILE);
        }
    }
     */
}
