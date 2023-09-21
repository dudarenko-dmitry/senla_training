package pl.senla.hotel.ie.file;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.utils.GuestUtil;
import pl.senla.hotel.utils.OrderUtil;
import pl.senla.hotel.utils.RoomReservationUtil;
import pl.senla.hotel.utils.RoomUtil;

import static pl.senla.hotel.constant.InputOutputConstant.*;

public class EntitiesConverter<T> implements Converter<T> {

    private final Header header;
    private final Configuration configuration;

    public EntitiesConverter() {
        this.configuration = AppConfiguration.getAppConfiguration();
        this.header = new Header();
    }

    public String getPath(Class<T> clazz) {
        String valueFilePath = configuration.getValueFilePath();
        if (clazz.equals(Room.class) || clazz.equals(HotelFacility.class)) {
            return valueFilePath + configuration.getValueFileHotelFacilitiesName();
        } else if (clazz.equals(Guest.class)) {
            return valueFilePath + configuration.getValueFileGuestsName();
        } else if (clazz.equals(RoomReservation.class) || clazz.equals(HotelService.class)) {
            return valueFilePath + configuration.getValueFileHotelServicesName();
        } else if (clazz.equals(Order.class)) {
            return valueFilePath + configuration.getValueFileOrdersName();
        } else {
            System.out.println(ERROR_GET_PATH);
            return "";
        }
    }

    public String[] getHeader(Class<T> clazz) {
        if (clazz.equals(Room.class) || clazz.equals(HotelFacility.class)) {
            return header.getHeaderHotelFacilityRoom();
        } else if (clazz.equals(Guest.class)) {
            return header.getHeaderGuest();
        } else if (clazz.equals(RoomReservation.class) || clazz.equals(HotelService.class)) {
            return header.getHeaderHotelServiceRoomReservation();
        } else if (clazz.equals(Order.class)) {
            return header.getHeaderOrder();
        } else {
            System.out.println(ERROR_GET_HEADER);
            return null;
        }
    }

    public String[] convertEntityToString(T t) {
        if (t.getClass().equals(Room.class)) {
            return RoomUtil.convertFacilityToString((HotelFacility) t);
        } else if (t.getClass().equals(Guest.class)) {
            return GuestUtil.convertGuestToString((Guest) t);
        } else if (t.getClass().equals(RoomReservation.class)) {
            return RoomReservationUtil.convertHotelServiceToString((HotelService) t);
        } else if (t.getClass().equals(Order.class)) {
            return OrderUtil.convertOrderToString((Order) t);
        } else {
            System.out.println(ERROR_CONVERTER_ENTITY);
            return null;
        }
    }

    public T convertStringToEntity(Class<T> clazz, String csvT) {
        if (csvT != null) {
            if (clazz.equals(Room.class) || clazz.equals(HotelFacility.class)) {
                return (T) RoomUtil.convertStringToRoom(csvT);
            } else if (clazz.equals(Guest.class)) {
                return (T) GuestUtil.convertStringToOrder(csvT);
            } else if (clazz.equals(RoomReservation.class) || clazz.equals(HotelService.class)) {
                return (T) RoomReservationUtil.convertCsvToRoomReservation(csvT);
            } else if (clazz.equals(Order.class)) {
                return (T) OrderUtil.convertStringToOrder(csvT);
            } else {
                System.out.println(ERROR_CONVERTER_STRING);
            }
        }
        return null;
    }
}
