package pl.senla.hotel.controller;

import java.util.List;

public interface ControllerCRUDALL<T> {

    List<T> readAll();
    boolean create(T t);
    T read(int id);
    boolean update(T t);
    boolean delete(int id);

}
