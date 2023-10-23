package pl.senla.hotel.controller;

import java.util.List;

public interface ControllerCRUDALL<T> {

    List<T> readAll();
    boolean create(String tString) throws IllegalAccessException;
    T read(int id);
    boolean update(int id, String tString);
    boolean delete(int id);

}
