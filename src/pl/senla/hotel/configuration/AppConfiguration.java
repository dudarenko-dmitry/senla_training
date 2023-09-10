package pl.senla.hotel.configuration;

import java.util.Map;

public class AppConfiguration {

    public static final String KEY_ABLE_TO_CHANGE_ROOM_STATUS = "Permission to change room's status";
    public static final String KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM = "Number of records for Room";
    public static final String KEY_FILE_PATH = "File path";
    public static final String KEY_FILE_HOTEL_FACILITIES_NAME = " File name for Hotel Facilities";
    public static final String KEY_FILE_GUESTS_NAME = "File name for Guest";
    public static final String KEY_FILE_HOTEL_SERVICES_NAME = "File name for Hotel Services";
    public static final String KEY_FILE_ORDERS_NAME = "File name for Orders";

    private final PropertiesLoader propertiesLoader = new AppPropertiesLoader();
    private final Map<String, String> properties = propertiesLoader.loadConfiguration();

    public Boolean getValueIsAbleToChangeRoomStatus() {
        return Boolean.valueOf(properties.get(KEY_ABLE_TO_CHANGE_ROOM_STATUS));
    }

    public Integer getValueNumberOfGuestRecordsForRoom() {
        return Integer.valueOf(properties.get(KEY_NUMBER_OF_GUEST_RECORDS_FOR_ROOM));
    }

    public String getValueFilePath() {
        return properties.get(KEY_FILE_PATH);
    }

    public String getValueFileHotelFacilitiesName() {
        return properties.get(KEY_FILE_HOTEL_FACILITIES_NAME);
    }

    public String getValueFileGuestsName() {
        return properties.get(KEY_FILE_GUESTS_NAME);
    }

    public String getValueFileHotelServicesName() {
        return properties.get(KEY_FILE_HOTEL_SERVICES_NAME);
    }

    public String getValueFileOrdersName() {
        return properties.get(KEY_FILE_ORDERS_NAME);
    }
}
