package pl.senla.hotel.repository;

import java.util.List;

public interface Repository<T> {

    List<T> readAll();
    boolean create(T t);
    T read(int id);
    boolean update(int id, T t);
    boolean delete(int id);

}
