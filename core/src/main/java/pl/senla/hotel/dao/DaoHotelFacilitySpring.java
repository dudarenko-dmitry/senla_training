package pl.senla.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.senla.hotel.entity.facilities.Room;

@Repository
public interface DaoHotelFacilitySpring extends JpaRepository<Room, Integer> {

}
