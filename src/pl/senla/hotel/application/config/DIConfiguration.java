package pl.senla.hotel.application.config;

public class DIConfiguration implements Configuration {

    @Override
    public String setPackageToScan() {
        return "pl.senla.hotel";
    }

    @Override
    public String setPropertiesDirectory() {
        return "C://IT/senla_training/src/pl/senla/hotel/resources/";
    }

    @Override
    public String setPropertiesFileName() {
        return "hotel.properties";
    }
}
