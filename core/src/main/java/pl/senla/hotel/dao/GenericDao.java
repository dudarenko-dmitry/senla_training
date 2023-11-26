package pl.senla.hotel.dao;

import java.util.List;

public interface GenericDao<T> {

    List<T> readAll();
    boolean create(T t);
    T read(int id);
    boolean update(int id, T t);
    boolean delete(int id);

}
