package pl.senla.hotel.service;

import pl.senla.hotel.entity.Order;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ServiceOrder extends ServiceCRUDALL<Order> {

    boolean addServicesToOrder(int idOrder) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<Integer> readAllIdServicesForOrder(int idOrder);
}
