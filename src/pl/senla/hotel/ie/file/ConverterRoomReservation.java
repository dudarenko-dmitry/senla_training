package pl.senla.hotel.ie.file;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;

import pl.senla.hotel.utils.RoomReservationUtil;

import static pl.senla.hotel.constant.PropertiesConstant.KEY_FILE_HOTEL_SERVICES_NAME;
import static pl.senla.hotel.constant.PropertiesConstant.KEY_FILE_PATH;

public class ConverterRoomReservation implements ConverterEntity<HotelService> {

    private final Configuration configuration;

    public ConverterRoomReservation() {
        this.configuration = AppConfiguration.getAppConfiguration();
    }

    public String getPath() {
        return configuration.getStringProperty(KEY_FILE_PATH) + configuration.getStringProperty(KEY_FILE_HOTEL_SERVICES_NAME);
    }

    public String[] getHeader() {
        return new String[]{"idService", "idOrder", "typeOfService", "idGuest", "idRoom",
                "checkInTime", "numberOfDays", "checkOutTime", "cost"};
    }

    public String[] convertEntityToString(HotelService t) {
        return RoomReservationUtil.convertHotelServiceToString(t);
    }

    public RoomReservation convertStringToEntity(String csvT) {
        return RoomReservationUtil.convertCsvToRoomReservation(csvT);
    }
}
