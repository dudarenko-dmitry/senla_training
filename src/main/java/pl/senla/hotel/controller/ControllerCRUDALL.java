package pl.senla.hotel.controller;

import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerCRUDALL<TRead, TCreate> {

    List<TRead> readAll(
            @RequestParam(value = "sort", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "category", required = false, defaultValue = "ROOM") String filter);
    TRead create(TCreate tCreate) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException;
    TRead read(Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    TRead update(Integer id, TCreate tUpdate) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    void delete(Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}
