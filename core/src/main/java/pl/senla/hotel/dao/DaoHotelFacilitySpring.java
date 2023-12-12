package pl.senla.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.senla.hotel.entity.facilities.Room;

import java.util.List;

@Repository
public interface DaoHotelFacilitySpring extends JpaRepository<Room, Integer> {

    List<Room> findByOrderByPrice();
    List<Room> findByOrderByCapacity();
    List<Room> findByOrderByRoomLevel();
    List<Room> findByOrderByCategory();
}

