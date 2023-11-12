package pl.senla.hotel.controller;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.ServiceOrder;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AppComponent
public class ControllerOrderCollection implements ControllerOrder {

    @GetInstance(beanName = "ServiceOrderImpl")
    private ServiceOrder orderService;

    public ControllerOrderCollection() {
    }

    @Override
    public List<Order> readAll() {
        return orderService.readAll();
    }

    @Override
    public boolean create(String orderString) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        return orderService.create(orderString);
    }

    @Override
    public Order read(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        return orderService.read(idOrder);
    }

    @Override
    public boolean update(int idOrder, String orderString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return orderService.update(idOrder, orderString);
    }

    @Override
    public boolean delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        return orderService.delete(id);
    }

    @Override
    public boolean addServicesToOrder(int idOrder) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return orderService.addServicesToOrder(idOrder);
    }

    @Override
    public List<Integer> readAllIdServicesForOrder(int idOrder) {
        return orderService.readAllIdServicesForOrder(idOrder);
    }
}
