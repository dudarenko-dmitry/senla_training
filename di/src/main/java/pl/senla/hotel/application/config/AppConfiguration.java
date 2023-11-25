package pl.senla.hotel.application.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppConfiguration implements Configuration {

    @Override
    public String getPackageToScan() {
        log.debug("getPackageToScan: START.");
        return "pl.senla.hotel";
    }

    @Override
    public String getPropertiesDirectory() {
        log.debug("getPropertiesDirectory: START.");
        return "C://IT/senla_training/di/src/main/java/pl/senla/hotel/resources";
    }

    @Override
    public String getHotelPropertiesFileName() {
        log.debug("getHotelPropertiesFileName: START.");
        return "hotel.properties";
    }

    @Override
    public String getDBPropertiesFileName() {
        log.debug("getDBPropertiesFileName: START.");
        return "db.properties";
    }
}
