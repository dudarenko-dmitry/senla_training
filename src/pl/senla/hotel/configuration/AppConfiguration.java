package pl.senla.hotel.configuration;

import java.util.Map;

import static pl.senla.hotel.constant.PropertiesConstant.*;

public class AppConfiguration implements Configuration{

    private final Map<String, String> properties;

    public AppConfiguration() {
        PropertiesLoader propertiesLoader = new AppPropertiesLoader();
        properties = propertiesLoader.loadConfiguration();
    }

    @Override
    public Boolean getValueIsAbleToChangeRoomStatus() {
        return Boolean.valueOf(properties.get(KEY_ABLE_TO_CHANGE_ROOM_STATUS));
    }

    @Override
    public Integer getValueNumberOfGuestRecordsForRoom() {
        return Integer.valueOf(properties.get(KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM));
    }

    @Override
    public String getValueFilePath() {
        return properties.get(KEY_FILE_PATH);
    }

    @Override
    public String getValueFilePathSerializable() {
        return properties.get(KEY_FILE_PATH_SERIALIZABLE);
    }

    @Override
    public String getValueFileSerializableName() {
        return properties.get(KEY_FILE_SERIALIZABLE_NAME);
    }

    public String getValueFileHotelFacilitiesName() {
        return properties.get(KEY_FILE_HOTEL_FACILITIES_NAME);
    }

    @Override
    public String getValueFileGuestsName() {
        return properties.get(KEY_FILE_GUESTS_NAME);
    }

    @Override
    public String getValueFileHotelServicesName() {
        return properties.get(KEY_FILE_HOTEL_SERVICES_NAME);
    }

    @Override
    public String getValueFileOrdersName() {
        return properties.get(KEY_FILE_ORDERS_NAME);
    }
}
