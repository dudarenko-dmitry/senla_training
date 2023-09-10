package pl.senla.hotel.ie;

import com.opencsv.*;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pl.senla.hotel.constant.InputOutputConstant.*;

public class ReaderWriter<T> implements ReaderWriterUniversal<T>{

    private final Header header;

    public ReaderWriter() {
        this.header = new Header();
    }

    @Override
    public List<T> load(Class<T> clazz) throws IOException {
        List<T> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getPath(clazz)))) {
            String csvT;
            int i = 0;
            while((csvT = bufferedReader.readLine()) != null) {
                if (i != 0) {
                    list.add(convertStringToEntity(clazz, csvT));
                }
                i++;
            }
        }
        return list;
    }

    @Override
    public void save(List<T> list) throws IOException {
        Class<?> clazz = list.get(0).getClass();
        CSVWriter writer = new CSVWriter(new FileWriter(getPath(clazz)),
                ';',
                '\'',
                '\\',
                "\n");
        writer.writeNext(getHeader(clazz));
        for (T t : list) {
            if (t != null) {
                String[] tStrings = convertEntityToString(t);
                writer.writeNext(tStrings);
            }
        }
        System.out.println(clazz.getName() + DATA_SAVED);
        writer.close();
    }

    private String getPath(Class<?> clazz) {
        if (clazz.equals(Room.class) || clazz.equals(HotelFacility.class)) {
            return PATH_HOTEL_FACILITY_ROOM;
        } else if (clazz.equals(Guest.class)) {
            return PATH_GUEST;
        } else if (clazz.equals(RoomReservation.class) || clazz.equals(HotelService.class)) {
            return PATH_SERVICES_ROOM_RESERVATION;
        } else if (clazz.equals(Order.class)) {
            return PATH_ORDER;
        } else {
            System.out.println(ERROR_GET_PATH);
            return "";
        }
    }

    private String[] getHeader(Class<?> clazz) {
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

    private String[] convertEntityToString(T t) {
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

    private T convertStringToEntity(Class<? super T> clazz, String csvT) {
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
