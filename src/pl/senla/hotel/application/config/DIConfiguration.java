package pl.senla.hotel.application.config;

public class DIConfiguration implements Configuration {

    @Override
    public String getPackageToScan() {
        return "pl.senla.hotel";
    }

    @Override
    public String getPropertiesDirectory() {
        return "C://IT/senla_training/src/pl/senla/hotel/resources/";
    }

    @Override
    public String getPropertiesFileName() {
        return "hotel.properties";
    }
}
