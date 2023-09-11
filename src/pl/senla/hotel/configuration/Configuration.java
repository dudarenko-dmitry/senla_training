package pl.senla.hotel.configuration;

public interface Configuration {

    Boolean getValueIsAbleToChangeRoomStatus();
    Integer getValueNumberOfGuestRecordsForRoom();
    String getValueFilePath();
    String getValueFileHotelFacilitiesName();
    String getValueFileGuestsName();
    String getValueFileHotelServicesName();
    String getValueFileOrdersName();
}
