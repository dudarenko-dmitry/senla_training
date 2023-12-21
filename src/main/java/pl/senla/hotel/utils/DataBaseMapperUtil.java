package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.dto.OrderDto;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import static pl.senla.hotel.constant.DBConstant.DB_NO_TABLE;

@Slf4j
public final class DataBaseMapperUtil {

    private DataBaseMapperUtil() {
    }

    public static Map<String, String> getMapper(Class<?> type) {
        Map<String, String> mapper = null;
        if (type.equals(Room.class)) {
            mapper = getRoomMapper();
        } else if (type.equals(Guest.class)) {
            mapper = getGuestMapper();
        } else if (type.equals(HotelService.class)) {
            mapper = getHotelServiceMapper();
        } else if (type.equals(OrderDto.class) || type.equals(Order.class)) {
            mapper = getOrderMapper();
        } else {
            log.warn(DB_NO_TABLE, new SQLException());
        }
        return mapper;
    }

    private static Map<String, String> getRoomMapper() {
        Map<String, String> roomMapper = new LinkedHashMap<>();
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
        Map<String, String> guestMapper = new LinkedHashMap<>();
        guestMapper.put("tableName", "hotel.guests");
        guestMapper.put("idGuest", "guestID");
        guestMapper.put("name", "name");
        guestMapper.put("phoneNumber", "phone");
        return guestMapper;
    }

    private static Map<String, String> getHotelServiceMapper() {
        Map<String, String> hotelServiceMapper = new LinkedHashMap<>();
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
        Map<String, String> orderMapper = new LinkedHashMap<>();
        orderMapper.put("tableName", "hotel.orders");
        orderMapper.put("idOrder", "orderID");
        orderMapper.put("idGuest", "guestID");
        return orderMapper;
    }

}
