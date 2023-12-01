package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.OrderDto;
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
    private GenericDao<OrderDto> daoOrderDto;
    @GetInstance(beanName = "DaoFacilityHibernate")
    private GenericDao<Room> daoRoom;

    public ServiceOrderDB() {}

    @Override
    public List<Order> readAll() {
        log.debug("START: Order ReadAll");
        List<OrderDto> orderDtoList = daoOrderDto.readAll();
        if (orderDtoList.isEmpty()) {
            log.debug(READ_ALL_ORDERS_IS_EMPTY);
        }
        return orderDtoList.stream().map(this::convertOrderDto).toList();
    }

    @Override
    public boolean create(String orderString) {
        log.debug("START: Order Create");
        int idGuest = Integer.parseInt(orderString);
        OrderDto order = new OrderDto(idGuest);
        order.getGuest().setIdGuest(idGuest);
        return daoOrderDto.create(order);
    }

    @Override
    public Order read(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: Order Read");
        if (daoOrderDto.read(idOrder) != null) {
            OrderDto orderDto = daoOrderDto.read(idOrder);
            return convertOrderDto(orderDto);
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
            return daoOrderDto.delete(idOrder);
        }
        log.debug(ORDER_NOT_EXISTS);
        return false;
    }

    @Override
    public boolean addServicesToOrder(int idOrder) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: Add Service to Order");
        if (daoOrderDto.readAll().isEmpty()) {
            log.debug(READ_ALL_ORDERS_IS_EMPTY);
            return false;
        } else if (read(idOrder) == null) {
            log.debug(ORDER_NOT_EXISTS);
            log.debug(ERROR_INPUT);
            return false;
        }
        OrderDto orderOld = daoOrderDto.read(idOrder);
        OrderDto orderUpdate = new OrderDto(); // read from String
        orderUpdate.setIdOrder(idOrder);
        orderUpdate.setGuest(orderOld.getGuest());
        return daoOrderDto.update(idOrder, orderUpdate);
    }

    @Override
    public List<Integer> readAllIdServicesForOrder(int idOrder) {
        log.debug("START: ReadAll Services for Order");
        return serviceHotelService.readAll()
                .stream()
                .filter(o -> o.getIdOrder() == idOrder)
                .map(HotelService::getIdService)
                .toList();
    }

    private Order convertOrderDto(OrderDto orderDto) {
        log.debug("START: Convert DTO to Order");
        Order order = new Order();
        order.setIdOrder(orderDto.getIdOrder()); // косяк
        order.setGuest(orderDto.getGuest());
        order.setIdServices(readAllIdServicesForOrder(orderDto.getIdOrder()));
        return order;
    }

}
