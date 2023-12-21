package pl.senla.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.senla.hotel.entity.Guest;

@Repository
public interface DaoGuestSpring extends JpaRepository<Guest, Integer> {

    @Query(value = "SELECT count(guestID)" +
            " FROM hotel.guests",
            nativeQuery = true)
    int countFindAll();

    Guest getReferenceByName(String name);
}
