package pl.senla.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.senla.hotel.entity.services.HotelService;

import java.util.List;

@Repository
public interface DaoHotelServiceSpring extends JpaRepository<HotelService, Integer> {

    List<HotelService> findByOrderByCheckOutTime();

    @Query(value = "SELECT count(guestID)" +
            "FROM hotel.reservations as r " +
            "WHERE DATE(?) BETWEEN check_in AND check_out",
    nativeQuery = true)
    int countGuestOnDate(String checkedDateString);

    @Query(value = "SELECT " +
            "new example.HotelServiceAndGuest(r.serviceID, r.orderID, g.guestID, g.name, " +
            "r.service_type, r.facilityID, r.check_in, r.check_out, r.day, r.cost) " +
            "FROM hotel.reservations r " +
            "JOIN hotel.guests g " +
            "ON r.guestID=g.guestID " +
            "ORDER BY name",
    nativeQuery = true)
    List<Object[]> findAllOrderByGuestName();
}
