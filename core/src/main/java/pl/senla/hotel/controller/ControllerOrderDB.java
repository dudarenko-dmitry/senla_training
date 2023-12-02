package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.ServiceOrder;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AppComponent
@Slf4j
public class ControllerOrderDB implements ControllerOrder {

    @GetInstance(beanName = "ServiceOrderDB")
    private ServiceOrder orderService;

    public ControllerOrderDB() {
    }

    @Override
    public List<Order> readAll() {
        log.debug("ControllerOrder call ServiceOrder's method 'readAll'.");
        return orderService.readAll();
    }

    @Override
    public boolean create(String orderString) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        log.debug("ControllerOrder call ServiceOrder's method 'create'.");
        return orderService.create(orderString);
    }

    @Override
    public Order read(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'read'.");
        return orderService.read(idOrder);
    }

    @Override
    public boolean update(int idOrder, String orderString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'update'.");
        return orderService.update(idOrder, orderString);
    }

    @Override
    public boolean delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'delete'.");
        return orderService.delete(id);
    }

    @Override
    public boolean addServicesToOrder(int idOrder) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'addServicesToOrder'.");
        return orderService.addServicesToOrder(idOrder);
    }

    @Override
    public List<Integer> readAllIdServicesForOrder(int idOrder) {
        log.debug("ControllerOrder call ServiceOrder's method 'readAllIdServicesForOrder'.");
        return orderService.readAllIdServicesForOrder(idOrder);
    }
}
