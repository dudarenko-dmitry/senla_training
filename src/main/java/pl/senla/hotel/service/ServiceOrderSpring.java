package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.senla.hotel.dao.DaoGuestSpring;
import pl.senla.hotel.dao.DaoHotelFacilitySpring;
import pl.senla.hotel.dao.DaoOrderSpring;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.OrderConstant.READ_ALL_ORDERS_IS_EMPTY;
import static pl.senla.hotel.constant.OrderConstant.ORDER_NOT_EXISTS;

@Service
@Slf4j
public class ServiceOrderSpring implements ServiceOrder {

    @Autowired
    private ServiceHotelService serviceHotelService;
    @Autowired
    private DaoOrderSpring daoOrder;
    @Autowired
    private DaoHotelFacilitySpring daoRoom;
    @Autowired
    private DaoGuestSpring daoGuest;

    public ServiceOrderSpring() {}

    @Override
    public List<Order> readAll() {
        log.debug("START: Order ReadAll");
        List<Order> orderList = daoOrder.findAll();
        if (orderList.isEmpty()) {
            log.debug(READ_ALL_ORDERS_IS_EMPTY);
        }
        return orderList;
    }

    @Override
    public Order create(String orderString) {
        log.debug("START: Order Create");
        int idGuest = Integer.parseInt(orderString);
        Order order = new Order();
        Optional<Guest> guest = daoGuest.findById(idGuest);
        guest.ifPresent(order::setGuest);
        return daoOrder.save(order);
    }

    @Override
    public Order read(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: Order Read");
        Optional<Order> order = daoOrder.findById(idOrder);
        if (order.isPresent()) {
            return order.get();
        }
        log.debug(ERROR_INPUT);
        return null;
    }

    @Override
    public Order update(int idOrder, Object t2New) {
// this method is never used.
// Updating of Order is processed by updating of its reservations in pl.senla.hotel.ui.services;
        log.debug("this method is never used");
        log.debug("Updating of Order is processed by updating of its reservations" +
                " in pl.senla.hotel.ui.services by method <<updateHotelServiceList>>");
        return null;
    }

    @Override
    public void delete(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: Order Delete");
        if (daoOrder.findById(idOrder).isPresent()) {
            daoOrder.deleteById(idOrder);
        }
        log.debug(ORDER_NOT_EXISTS);
    }

    @Override
    public List<HotelService> readAllIdServicesForOrder(int idOrder) {
        log.debug("START: ReadAll Services for Order");
        return serviceHotelService.findServicesForOrder(idOrder);
    }

}
