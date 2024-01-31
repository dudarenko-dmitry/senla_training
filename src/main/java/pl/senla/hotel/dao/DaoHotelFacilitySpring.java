package pl.senla.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.senla.hotel.entity.facilities.Room;

import java.util.List;

@Repository
public interface DaoHotelFacilitySpring extends JpaRepository<Room, Integer> {

    List<Room> findByOrderByPrice();
    List<Room> findByOrderByCapacity();
    List<Room> findByOrderByRoomLevel();
    List<Room> findByOrderByCategory();
    Room getRoomByNameFacility(String nameFacility);

    @Query(value = "SELECT r.facilityID, r.category, r.name_facility, r.price, r.capacity, r.level, r.status " +
            " FROM hotel.rooms AS r " +
            "EXCEPT " +
            "(SELECT r2.facilityID, r2.category, r2.name_facility, r2.price, r2.capacity, r2.level, r2.status " +
            " FROM hotel.rooms AS r2 " +
            "JOIN hotel.reservations AS rr " +
            "ON r2.facilityID=rr.facilityID " +
            "WHERE DATE(?) BETWEEN rr.check_in AND rr.check_out)",
            nativeQuery = true)
    List<Room> readAllRoomsFreeOnDate(String checkedTimeString);

    @Query(value = "SELECT r.facilityID, r.category, r.name_facility, r.price, r.capacity, r.level, r.status " +
            " FROM hotel.rooms AS r " +
            "EXCEPT " +
            "(SELECT r2.facilityID, r2.category, r2.name_facility, r2.price, r2.capacity, r2.level, r2.status " +
            " FROM hotel.rooms AS r2 " +
            "JOIN hotel.reservations AS rr " +
            "ON r2.facilityID=rr.facilityID " +
            "WHERE DATE(?) BETWEEN rr.check_in AND rr.check_out)" +
            "ORDER BY price",
            nativeQuery = true)
    List<Room> readAllRoomsFreeOnDateOrderByPrice(String checkedTimeString);

    @Query(value = "SELECT r.facilityID, r.category, r.name_facility, r.price, r.capacity, r.level, r.status " +
            " FROM hotel.rooms AS r " +
            "EXCEPT " +
            "(SELECT r2.facilityID, r2.category, r2.name_facility, r2.price, r2.capacity, r2.level, r2.status " +
            " FROM hotel.rooms AS r2 " +
            "JOIN hotel.reservations AS rr " +
            "ON r2.facilityID=rr.facilityID " +
            "WHERE DATE(?) BETWEEN rr.check_in AND rr.check_out)" +
            "ORDER BY capacity",
            nativeQuery = true)
    List<Room> readAllRoomsFreeOnDateOrderByCapacity(String checkedTimeString);

    @Query(value = "SELECT r.facilityID, r.category, r.name_facility, r.price, r.capacity, r.level, r.status " +
            " FROM hotel.rooms AS r " +
            "EXCEPT " +
            "(SELECT r2.facilityID, r2.category, r2.name_facility, r2.price, r2.capacity, r2.level, r2.status " +
            " FROM hotel.rooms AS r2 " +
            "JOIN hotel.reservations AS rr " +
            "ON r2.facilityID=rr.facilityID " +
            "WHERE DATE(?) BETWEEN rr.check_in AND rr.check_out)" +
            "ORDER BY level",
            nativeQuery = true)
    List<Room> readAllRoomsFreeOnDateOrderByLevel(String checkedTimeString);

    // not ready
    @Query(value = "SELECT count(facilityID) FROM " +
            "(SELECT r.facilityID, r.category, r.name_facility, r.price, r.capacity, r.level, r.status " +
            " FROM hotel.rooms AS r " +
            "EXCEPT " +
            "(SELECT r2.facilityID, r2.category, r2.name_facility, r2.price, r2.capacity, r2.level, r2.status " +
            " FROM hotel.rooms AS r2 " +
            "JOIN hotel.reservations AS rr " +
            "ON r2.facilityID=rr.facilityID " +
            "WHERE DATE(?) BETWEEN rr.check_in AND rr.check_out)) AS total",
            nativeQuery = true)
    Integer countFreeRoomsInTime(String checkedTimeString);

}

