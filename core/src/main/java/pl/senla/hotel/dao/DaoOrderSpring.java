package pl.senla.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.senla.hotel.entity.Order;

@Repository
public interface DaoOrderSpring extends JpaRepository<Order, Integer> {

}
