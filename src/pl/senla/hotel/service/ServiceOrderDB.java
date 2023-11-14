package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.OrderDto;
import pl.senla.hotel.entity.facilities.HotelFacility;
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
    private GenericDao<OrderDto> daoOrderDto;
    @GetInstance(beanName = "DaoFacilityDB")
    private GenericDao<HotelFacility> daoRoom;

    public ServiceOrderDB() {}

    @Override
    public List<Order> readAll() {
        if (daoOrderDto.readAll() != null || !daoOrderDto.readAll().isEmpty()) {
            List<OrderDto> orderDtos = daoOrderDto.readAll();
            return orderDtos.stream().map(this::convertOrderDto).toList();
        }
        System.out.println(READ_ALL_ORDERS_IS_EMPTY);
        return Collections.emptyList();
    }

    @Override
    public boolean create(String orderString) throws IllegalAccessException {
        int idGuest = Integer.parseInt(orderString);
        OrderDto order = new OrderDto(idGuest);
        order.setIdGuest(idGuest);
        int idOrderNew = getIdOrderNew();
        order.setIdOrder(idOrderNew);
        return daoOrderDto.create(order);
    }

    @Override
    public Order read(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if (daoOrderDto.read(idOrder) != null) {
            OrderDto orderDto = daoOrderDto.read(idOrder);
            Order order = convertOrderDto(orderDto);
            return order;
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
            return daoOrderDto.delete(idOrder);
        }
        System.out.println(ORDER_NOT_EXISTS);
        return false;
    }

    @Override
    public boolean addServicesToOrder(int idOrder) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (daoOrderDto.readAll() == null || daoOrderDto.readAll().isEmpty()) {
            System.out.println(READ_ALL_ORDERS_IS_EMPTY);
            return false;
        } else if (read(idOrder) == null) {
            System.out.println(ORDER_NOT_EXISTS);
            System.out.println(ERROR_INPUT);
            return false;
        }
//        List<Integer> idServicesInOrder = readAllIdServicesForOrder(idOrder);
        OrderDto orderOld = daoOrderDto.read(idOrder);
        OrderDto orderUpdate = new OrderDto(); // read from String
        orderUpdate.setIdOrder(idOrder);
        orderUpdate.setIdGuest(orderOld.getIdGuest());
//        orderUpdate.setServices(idServicesInOrder);
        return daoOrderDto.update(idOrder, orderUpdate);
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
    public List<Integer> readAllIdServicesForOrder(int idOrder) {
        return serviceHotelService.readAll()
                .stream()
                .filter(o -> o.getIdOrder() == idOrder)
                .map(HotelService::getIdService)
                .toList();
    }

    private Order convertOrderDto(OrderDto orderDto) {
        Order order = new Order();
        order.setIdOrder(orderDto.getIdOrder());
        order.setIdGuest(orderDto.getIdGuest());
        order.setIdServices(readAllIdServicesForOrder(orderDto.getIdOrder()));
        return order;
    }

}
