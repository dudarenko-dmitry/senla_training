package pl.senla.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.senla.hotel.entity.services.HotelService;

import java.util.List;

@Repository
public interface DaoHotelServiceSpring extends JpaRepository<HotelService, Integer> {

    List<HotelService> findByOrderByCheckOutTime();
    List<HotelService> findByOrderByCheckInTime();
    List<HotelService> findByOrderByCost();

    @Query(value = "SELECT count(guestID)" +
            "FROM hotel.reservations as r " +
            "WHERE DATE(?) BETWEEN check_in AND check_out",
    nativeQuery = true)
    int countGuestOnDate(String checkedDateString);

    @Query(value = "SELECT g.name, r.serviceID, r.orderID, r.guestID, " +
            "r.service_type, r.facilityID, r.check_in, r.check_out, r.day, r.cost " +
            "FROM hotel.reservations r " +
            "JOIN hotel.guests g " +
            "ON r.guestID=g.guestID " +
            "ORDER BY name",
    nativeQuery = true)
    List<HotelService> findAllOrderByGuestName();

    @Query(value = "SELECT sum(cost) " +
            "FROM hotel.reservations " +
            "WHERE guestID=?",
    nativeQuery = true)
    int getSumForRoomByGuest(int idGuest);

    @Query(value = "SELECT rr.serviceID, rr.orderID, rr.guestID, " +
            "rr.service_type, rr.facilityID, rr.check_in, rr.check_out, rr.day, rr.cost " +
            "FROM hotel.reservations as rr " +
            "JOIN hotel.rooms as r " +
            "ON r.facilityID=rr.facilityID " +
            "WHERE r.facilityID=? " +
            "ORDER BY rr.check_in DESC " +
            "LIMIT 3",
    nativeQuery = true)
    List<HotelService> findLast3ByRoomId(int idRoom);
}
