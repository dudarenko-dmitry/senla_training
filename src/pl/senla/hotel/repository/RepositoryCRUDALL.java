package pl.senla.hotel.repository;

import java.util.List;

public interface RepositoryCRUDALL<T> {

    List<T> readAll();
    boolean create(T t);
    T read(int id);
    boolean update(int id, T t);
    boolean delete(int id);

}
