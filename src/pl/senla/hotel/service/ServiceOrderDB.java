package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.OrderConstant.READ_ALL_ORDERS_IS_EMPTY;
import static pl.senla.hotel.constant.OrderConstant.ORDER_NOT_EXISTS;

@AppComponent
public class ServiceOrderDB implements ServiceOrder {

    @GetInstance(beanName = "ServiceHotelServiceDB")
    private ServiceHotelService serviceHotelService;
    @GetInstance(beanName = "DaoOrderDB")
    private GenericDao<Order> daoOrder;
    @GetInstance(beanName = "DaoRoomDB")
    private GenericDao<Room> daoRoom;

    public ServiceOrderDB() {}

    @Override
    public List<Order> readAll() {
        if (daoOrder.readAll() != null || !daoOrder.readAll().isEmpty()) {
            return daoOrder.readAll();
        }
        System.out.println(READ_ALL_ORDERS_IS_EMPTY);
        return Collections.emptyList();
    }

    @Override
    public boolean create(String orderString) throws IllegalAccessException {
        int idGuest = Integer.parseInt(orderString);
        Order order = new Order(idGuest);
        order.setIdGuest(idGuest);
        int idOrderNew = getIdOrderNew();
        order.setIdOrder(idOrderNew);
//        startCreateHotelService.runMenu(idOrderNew, idGuest);
        order.setServices(null);
        return daoOrder.create(order);
    }

    @Override
    public Order read(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if (daoOrder.read(idOrder) != null) {
            return daoOrder.read(idOrder);
        }
        System.out.println(ERROR_INPUT);
        return null;
    }

    @Override
    public boolean update(int idOrder, String orderUpdatingString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
//        if (read(idOrder) != null) {
//            Order orderUpdate = new Order(); // read from String
//            return daoOrder.update(idOrder, orderUpdate);
//        }
        System.out.println(ORDER_NOT_EXISTS);
        System.out.println(ERROR_INPUT);
        return false;
    }

    @Override
    public boolean delete(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if (read(idOrder) != null) {
            return daoOrder.delete(idOrder);
        }
        System.out.println(ORDER_NOT_EXISTS);
        return false;
    }

    @Override
    public boolean addServicesToOrder(int idOrder) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (daoOrder.readAll() == null || daoOrder.readAll().isEmpty()) {
            System.out.println(READ_ALL_ORDERS_IS_EMPTY);
            return false;
        } else if (read(idOrder) == null) {
            System.out.println(ORDER_NOT_EXISTS);
            System.out.println(ERROR_INPUT);
            return false;
        }
        List<Integer> idServicesInOrder = readAllIdServicesForOrder(idOrder);
        Order orderOld = daoOrder.read(idOrder);
        Order orderUpdate = new Order(); // read from String
        orderUpdate.setIdOrder(idOrder);
        orderUpdate.setIdGuest(orderOld.getIdGuest());
        orderUpdate.setServices(idServicesInOrder);
        return daoOrder.update(idOrder, orderUpdate);
    }

    private int getIdOrderNew() {
        int lastId = readAll()
                .stream()
                .map(Order::getIdOrder)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        return lastId + 1;
    }

    @Override
    public List<Integer> readAllIdServicesForOrder(int idOrderNew) {
        return serviceHotelService.readAll()
                .stream()
                .filter(o -> o.getIdOrder() == idOrderNew)
                .map(HotelService::getIdService)
                .toList();
    }
}
