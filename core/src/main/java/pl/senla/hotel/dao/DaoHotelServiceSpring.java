package pl.senla.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.senla.hotel.entity.services.HotelService;

@Repository
public interface DaoHotelServiceSpring extends JpaRepository<HotelService, Integer> {

}
