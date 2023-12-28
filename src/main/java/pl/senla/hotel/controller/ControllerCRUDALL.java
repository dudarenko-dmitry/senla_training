package pl.senla.hotel.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerCRUDALL<TRead, TCreate> {

    List<TRead> readAll();
    TRead create(TCreate tCreate) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException;
    TRead read(Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    TRead update(Integer id, TCreate tUpdate) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    void delete(Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}
