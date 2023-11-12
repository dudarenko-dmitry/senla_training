package pl.senla.hotel.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerCRUDALL<T> {

    List<T> readAll();
    boolean create(String tString) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException;
    T read(int id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    boolean update(int id, String tString) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    boolean delete(int id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}
