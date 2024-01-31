package pl.senla.hotel.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ServiceCRUDALL<T1, T2> {

    List<T1> readAll();
    T1 create(T2 t2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException;
    T1 read(Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    T1 update(Integer id, T2 t2New) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    void delete(Integer id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}
