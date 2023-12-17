package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.senla.hotel.dao.DaoHotelFacilitySpring;
import pl.senla.hotel.dao.DaoOrderSpring;
import pl.senla.hotel.dto.OrderCreateDto;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.exceptions.OrderNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static pl.senla.hotel.constant.OrderConstant.ORDER_NOT_EXISTS;
import static pl.senla.hotel.constant.OrderConstant.READ_ALL_ORDERS_IS_EMPTY;

@Service
@Slf4j
public class ServiceOrderSpring implements ServiceOrder {

    @Autowired
    private ServiceRoomReservation serviceRoomReservation;
    @Autowired
    private ServiceGuest serviceGuest;
    @Autowired
    private DaoOrderSpring daoOrder;
    @Autowired
    private DaoHotelFacilitySpring daoRoom;

    public ServiceOrderSpring() {}

    @Override
    public List<Order> readAll() {
        log.debug("Service: Order ReadAll");
        List<Order> orders = daoOrder.findAll();
        if (orders.isEmpty()) {
            log.debug(READ_ALL_ORDERS_IS_EMPTY);
        }
        for (Order order : orders) {
            List<HotelService> hotelServices = serviceRoomReservation.findServicesForOrder(order.getIdOrder());
            order.setHotelServices(hotelServices);
        }
        return orders;
    }

    @Override
    public Order create(OrderCreateDto orderCreateDto) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("Service: Order Create");
        log.debug("Service get idGuest: " + orderCreateDto.getIdGuest());
        Guest guest = serviceGuest.read(orderCreateDto.getIdGuest());
        return daoOrder.save(new Order(guest));
    }

    @Override
    public Order read(Integer idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("Service: Order Read");
        Order order = daoOrder.findById(idOrder)
                .orElseThrow(() -> new OrderNotFoundException(idOrder));
        List<HotelService> hotelServices = serviceRoomReservation.findServicesForOrder(idOrder);
        order.setHotelServices(hotelServices);
        return order;
    }

    @Override
    public Order update(Integer idOrder, OrderCreateDto orderCreateDtoUpdate) {
// this method is never used.
// Updating of Order is processed by updating of its reservations in pl.senla.hotel.ui.services;
        log.debug("this method is never used");
        log.debug("Updating of Order is processed by updating of its reservations" +
                " in pl.senla.hotel.ui.services by method <<updateHotelServiceList>>");
        return null;
    }

    @Override
    public void delete(Integer idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("Service: Order Delete");
        if (daoOrder.findById(idOrder).isPresent()) {
            daoOrder.deleteById(idOrder);
        }
        log.debug(ORDER_NOT_EXISTS);
    }

}
