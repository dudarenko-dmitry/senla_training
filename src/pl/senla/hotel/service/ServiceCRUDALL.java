package pl.senla.hotel.service;

import java.util.List;

public interface ServiceCRUDALL<T> {

    List<T> readAll();
    boolean create(String tString);
    T read(int id);
    boolean update(int id, String tString);
    boolean delete(int id);

}
