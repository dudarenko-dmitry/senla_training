package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.OrderConstant.READ_ALL_ORDERS_IS_EMPTY;
import static pl.senla.hotel.constant.OrderConstant.ORDER_NOT_EXISTS;

@AppComponent
@Slf4j
public class ServiceOrderDB implements ServiceOrder {

    @GetInstance(beanName = "ServiceHotelServiceDB")
    private ServiceHotelService serviceHotelService;
    @GetInstance(beanName = "DaoOrderHibernate")
    private GenericDao<Order> daoOrder;
    @GetInstance(beanName = "DaoFacilityHibernate")
    private GenericDao<Room> daoRoom;
    @GetInstance(beanName = "DaoGuestHibernate")
    private GenericDao<Guest> daoGuest;

    public ServiceOrderDB() {}

    @Override
    public List<Order> readAll() {
        log.debug("START: Order ReadAll");
        List<Order> orderList = daoOrder.readAll();
        if (orderList.isEmpty()) {
            log.debug(READ_ALL_ORDERS_IS_EMPTY);
        }
        return orderList;
    }

    @Override
    public boolean create(String orderString) {
        log.debug("START: Order Create");
        int idGuest = Integer.parseInt(orderString);
        Order order = new Order(idGuest);
        order.setGuest(daoGuest.read(idGuest));
        return daoOrder.create(order);
    }

    @Override
    public Order read(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: Order Read");
        if (daoOrder.read(idOrder) != null) {
            return daoOrder.read(idOrder);
        }
        log.debug(ERROR_INPUT);
        return null;
    }

    @Override
    public boolean update(int idOrder, String orderUpdatingString) {
//        if (read(idOrder) != null) {
//            Order orderUpdate = new Order(); // read from String
//            return daoOrder.update(idOrder, orderUpdate);
//        }
        log.debug(ORDER_NOT_EXISTS);
        log.debug(ERROR_INPUT);
        return true;
    }

    @Override
    public boolean delete(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: Order Delete");
        if (read(idOrder) != null) {
            return daoOrder.delete(idOrder);
        }
        log.debug(ORDER_NOT_EXISTS);
        return false;
    }

    @Override
    public boolean addServicesToOrder(int idOrder) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Add Service to Order");
        if (daoOrder.readAll().isEmpty()) {
            log.debug(READ_ALL_ORDERS_IS_EMPTY);
            return false;
        } else if (read(idOrder) == null) {
            log.debug(ORDER_NOT_EXISTS);
            log.debug(ERROR_INPUT);
            return false;
        }
        Order orderOld = daoOrder.read(idOrder);
        Order orderUpdate = new Order(); // read from String
        orderUpdate.setIdOrder(idOrder);
        orderUpdate.setGuest(orderOld.getGuest());
        return daoOrder.update(idOrder, orderUpdate);
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
