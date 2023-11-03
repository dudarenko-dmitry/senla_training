package pl.senla.hotel.utils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataBaseMapperUtil {

    private DataBaseMapperUtil() {

    }

    public static Map<String, String> getMapper(Class<?> type) {
        Map<String, String> mapper = null;
        switch (type.getTypeName()) {
            case "HotelFacility" -> mapper = getRoomMapper();
            case "Guest" -> mapper = getGuestMapper();
            case "HotelService" -> mapper = getHotelServiceMapper();
            case "Order" -> mapper = getOrderMapper();
            default -> System.out.println("There is no such table in DB \n" + new SQLException());
        }
        return mapper;
    }

    private static Map<String, String> getRoomMapper() {
        Map<String, String> roomMapper = new HashMap<>();
        roomMapper.put("tableName", "hotel.rooms");
        roomMapper.put("idFacility", "facilityID");
        roomMapper.put("category", "category");
        roomMapper.put("nameFacility", "nameFacility");
        roomMapper.put("price", "price");
        roomMapper.put("capacity", "capacity");
        roomMapper.put("roomLevel", "level");
        roomMapper.put("roomStatus", "status");
        return roomMapper;
    }

    private static Map<String, String> getGuestMapper() {
        Map<String, String> guestMapper = new HashMap<>();
        guestMapper.put("tableName", "hotel.guests");
        guestMapper.put("idGuest", "guestID");
        guestMapper.put("name", "name");
        guestMapper.put("phoneNumber", "phone");
        return guestMapper;
    }

    private static Map<String, String> getHotelServiceMapper() {
        Map<String, String> hotelServiceMapper = new HashMap<>();
        hotelServiceMapper.put("tableName", "hotel.reservations");
        hotelServiceMapper.put("idService", "serviceID");
        hotelServiceMapper.put("idOrder", "orderID");
        hotelServiceMapper.put("typeOfService", "serviceType");
        hotelServiceMapper.put("idGuest", "guestID");
        hotelServiceMapper.put("idRoom", "facilityID");
        hotelServiceMapper.put("numberOfDays", "day");
        hotelServiceMapper.put("checkInTime", "checkIn");
        hotelServiceMapper.put("checkOutTime", "checkOut");
        hotelServiceMapper.put("cost", "cost");
        return hotelServiceMapper;
    }

    private static Map<String, String> getOrderMapper() {
        Map<String, String> orderMapper = new HashMap<>();
        orderMapper.put("tableName", "hotel.orders");
        orderMapper.put("idOrder", "orderID");
        orderMapper.put("idGuest", "guestID");
        // add getReservationList ?
        return orderMapper;
    }

}
