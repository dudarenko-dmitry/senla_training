package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Order;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerOrder extends ControllerCRUDALL<Order> {

    boolean addServicesToOrder(int idOrder) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<Integer> readAllIdServicesForOrder(int idOrderNew);
}
