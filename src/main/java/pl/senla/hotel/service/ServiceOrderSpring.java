package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.senla.hotel.dao.DaoGuestSpring;
import pl.senla.hotel.dao.DaoHotelFacilitySpring;
import pl.senla.hotel.dao.DaoOrderSpring;
import pl.senla.hotel.dto.OrderDto;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.exceptions.OrderNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static pl.senla.hotel.constant.OrderConstant.ORDER_NOT_EXISTS;
import static pl.senla.hotel.constant.OrderConstant.READ_ALL_ORDERS_IS_EMPTY;

@Service
@Slf4j
public class ServiceOrderSpring implements ServiceOrder {

    @Autowired
    private ServiceHotelService serviceHotelService;
    @Autowired
    private ServiceRoomReservation serviceRoomReservation;
    @Autowired
    private DaoOrderSpring daoOrder;
    @Autowired
    private DaoHotelFacilitySpring daoRoom;
    @Autowired
    private DaoGuestSpring daoGuest;

    public ServiceOrderSpring() {}

    @Override
    public List<Order> readAll() {
        log.debug("Service: Order ReadAll");
        List<Order> orderList = daoOrder.findAll();
        if (orderList.isEmpty()) {
            log.debug(READ_ALL_ORDERS_IS_EMPTY);
        }
        return orderList;
    }

    @Override
    public Order create(OrderDto orderDto) {
        log.debug("Service: Order Create");
        return daoOrder.save(new Order(orderDto.getIdGuest()));
    }

//    @Override
//    public Order read(int idOrder) throws InvocationTargetException, NoSuchMethodException,
//            InstantiationException, IllegalAccessException {
//        log.debug("Service: Order Read");
//        Optional<Order> order = daoOrder.findById(idOrder);
//        if (order.isPresent()) {
//            return order.get();
//        }
//        log.debug(ERROR_INPUT);
//        return null;
//    }

    @Override
    public Order read(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("Service: Order Read");
        return daoOrder.findById(idOrder)
                .orElseThrow(() -> new OrderNotFoundException(idOrder));
    }

    @Override
    public Order update(int idOrder, OrderDto orderDtoUpdate) {
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
        log.debug("Service: Order Delete");
        if (daoOrder.findById(idOrder).isPresent()) {
            daoOrder.deleteById(idOrder);
        }
        log.debug(ORDER_NOT_EXISTS);
    }

}
