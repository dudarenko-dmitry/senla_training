package pl.senla.hotel.configuration;

public interface Configuration {

    Boolean getValueIsAbleToChangeRoomStatus();
    Integer getValueNumberOfGuestRecordsForRoom();
    String getValueFilePath();

    String getValueFilePathSerializable();

    String getValueFileSerializableName();

    String getValueFileHotelFacilitiesName();
    String getValueFileGuestsName();
    String getValueFileHotelServicesName();
    String getValueFileOrdersName();
}
