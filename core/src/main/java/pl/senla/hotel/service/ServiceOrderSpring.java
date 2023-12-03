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
    public Order update(int idOrder, String orderUpdatingString) {
//        if (read(idOrder) != null) {
//            Order orderUpdate = new Order(); // read from String
//            return daoOrder.update(idOrder, orderUpdate);
//        }
        log.debug(ORDER_NOT_EXISTS);
        log.debug(ERROR_INPUT);
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
    public void addServicesToOrder(int idOrder) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Add Service to Order");
        if (daoOrder.findAll().isEmpty()) {
            log.debug(READ_ALL_ORDERS_IS_EMPTY);
        } else if (read(idOrder) == null) {
            log.debug(ORDER_NOT_EXISTS);
            log.debug(ERROR_INPUT);
        }
        Optional<Order> orderOld = daoOrder.findById(idOrder);
        if (orderOld.isPresent()) {
            Order orderUpdate = new Order(); // read from String
            orderUpdate.setIdOrder(idOrder);
            orderUpdate.setGuest(orderOld.get().getGuest());
            daoOrder.save(orderUpdate);
        }
        log.debug(ORDER_NOT_EXISTS);
    }

    @Override
    public List<Integer> readAllIdServicesForOrder(int idOrder) {
        log.debug("START: ReadAll Services for Order");
        return serviceHotelService.readAll()
                .stream()
                .filter(o -> o.getOrder().getIdOrder() == idOrder)
                .map(HotelService::getIdService)
                .toList();
    }

}
