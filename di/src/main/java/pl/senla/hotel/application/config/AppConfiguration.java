package pl.senla.hotel.application.config;

public class AppConfiguration implements Configuration {

    @Override
    public String getPackageToScan() {
        return "pl.senla.hotel";
    }

    @Override
    public String getPropertiesDirectory() {
//        return "C://IT/senla_training/src/pl/senla/hotel/resources/";
        return "C://IT/senla_training/di/src/main/java/pl/senla/hotel/resources";
    }

    @Override
    public String getHotelPropertiesFileName() {
        return "hotel.properties";
    }

    @Override
    public String getDBPropertiesFileName() {
        return "db.properties";
    }
}
