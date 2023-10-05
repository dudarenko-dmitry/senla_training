package pl.senla.hotel.annotations.config;

public class ConfigPropertyAnnotated {

    private static ConfigPropertyAnnotated configProperty;

    public ConfigPropertyAnnotated() {
    }

    public static ConfigPropertyAnnotated getConfigPropertyAnnotated() {
        if (configProperty == null) {
            configProperty = new ConfigPropertyAnnotated();
        }
        return configProperty;
    }

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.facilities")
    private String fileNameFacilities;

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.guest")
    private String fileNameGuest;

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.services")
    private String fileNameServices;

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.order")
    private String fileNameOrder;

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-path.directory")
    private String filePathDirectory;

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-path.serialization")
    private String filePathSerialization;

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.serialization")
    private String fileNameSerialization;

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "room-records.number", type = "Integer")
    private Integer roomRecordsNumber;

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "change-room-status.enabled", type = "Boolean")
    private Boolean changeRoomStatusEnabled;

}
