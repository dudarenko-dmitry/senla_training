package pl.senla.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericDao<T> extends JpaRepository<T, Integer> {

}
