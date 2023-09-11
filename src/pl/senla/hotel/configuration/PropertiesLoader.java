package pl.senla.hotel.configuration;

import java.util.Map;

public interface PropertiesLoader {

    Map<String, String> loadConfiguration();

    /**
     * use only for creation of new properties
         void saveConfiguration();
     */
}
