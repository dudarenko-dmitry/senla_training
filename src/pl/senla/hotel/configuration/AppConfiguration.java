package pl.senla.hotel.configuration;

import java.util.Properties;

import static pl.senla.hotel.constant.PropertiesConstant.*;

public class AppConfiguration implements Configuration{

    private static AppConfiguration appConfiguration;
    private final Properties properties;

    private AppConfiguration() {
        PropertiesLoader propertiesLoader = new AppPropertiesLoader();
        properties = propertiesLoader.loadConfiguration();
    }

    public static AppConfiguration getAppConfiguration() {
        if (appConfiguration == null) {
            appConfiguration = new AppConfiguration();
        }
        return appConfiguration;
    }

    @Override
    public Boolean getValueIsAbleToChangeRoomStatus() {
        return (Boolean) properties.get(KEY_ABLE_TO_CHANGE_ROOM_STATUS);
    }

    @Override
    public Integer getValueNumberOfGuestRecordsForRoom() {
        return (Integer) properties.get(KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM);
    }

    @Override
    public String getValueFilePath() {
        return String.valueOf(properties.get(KEY_FILE_PATH));
    }

    @Override
    public String getValueFilePathSerializable() {
        return String.valueOf(properties.get(KEY_FILE_PATH_SERIALIZABLE));
    }

    @Override
    public String getValueFileSerializableName() {
        return String.valueOf(properties.get(KEY_FILE_SERIALIZABLE_NAME));
    }

    @Override
    public String getValueFileHotelFacilitiesName() {
        return String.valueOf(properties.get(KEY_FILE_HOTEL_FACILITIES_NAME));
    }

    @Override
    public String getValueFileGuestsName() {
        return String.valueOf(properties.get(KEY_FILE_GUESTS_NAME));
    }

    @Override
    public String getValueFileHotelServicesName() {
        return String.valueOf(properties.get(KEY_FILE_HOTEL_SERVICES_NAME));
    }

    @Override
    public String getValueFileOrdersName() {
        return String.valueOf(properties.get(KEY_FILE_ORDERS_NAME));
    }
}
