package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.service.ServiceOrder;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@Slf4j
public class ControllerOrderSpring implements ControllerOrder {

    @Autowired
    private ServiceOrder orderService;

    @Override
    public List<Order> readAll() {
        log.debug("ControllerOrder call ServiceOrder's method 'readAll'.");
        return orderService.readAll();
    }

    @Override
    public Order create(String orderString) throws IllegalAccessException, InvocationTargetException,
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
    public Order update(int idOrder, String orderString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'update'.");
        return orderService.update(idOrder, orderString);
    }

    @Override
    public void delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'delete'.");
        orderService.delete(id);
    }

    @Override
    public List<HotelService> readAllServicesForOrder(int idOrder) {
        log.debug("ControllerOrder call ServiceOrder's method 'readAllIdServicesForOrder'.");
        return orderService.readAllIdServicesForOrder(idOrder);
    }
}
