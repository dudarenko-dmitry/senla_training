package pl.senla.hotel.service;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.repository.RepositoryHotelService;
import pl.senla.hotel.repository.RepositoryHotelServiceCollection;
import pl.senla.hotel.repository.RepositoryOrder;
import pl.senla.hotel.repository.RepositoryOrderCollection;
import pl.senla.hotel.ui.services.StartCreateHotelService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.OrderConstant.*;

public class ServiceOrderImpl implements ServiceOrder {

    private static ServiceOrder serviceOrder;
    private final RepositoryOrder repositoryOrder;
    private final RepositoryHotelService repositoryHotelService;


    private ServiceOrderImpl() {
        this.repositoryOrder = RepositoryOrderCollection.getRepositoryOrder();
        this.repositoryHotelService = RepositoryHotelServiceCollection.getRepositoryHotelService();
    }

    public static ServiceOrder getServiceOrder() {
        if (serviceOrder == null) {
            serviceOrder = new ServiceOrderImpl();
        }
        return serviceOrder;
    }

    @Override
    public List<Order> readAll() {
        if (repositoryOrder.readAll() == null || repositoryOrder.readAll().isEmpty()) {
            System.out.println(ERROR_READ_ALL_ORDERS);
            return Collections.emptyList();
        }
        return repositoryOrder.readAll();
    }

    @Override
    public boolean create(String orderString) {
        int idGuest = Integer.parseInt(orderString);
        Order order = new Order(idGuest);
        order.setIdOrder(-1);
        order.setIdGuest(idGuest);
        int idOrderNew = getIdOrderNew();
        order.setIdOrder(idOrderNew);
        StartCreateHotelService.getStartCreateHotelService().runMenu(idOrderNew, idGuest);
        List<HotelService> servicesInOrder = readAllServicesForOrder(idOrderNew);
        order.setServices(servicesInOrder);
        return repositoryOrder.create(order);
    }

    @Override
    public Order read(int idOrder) {
        if (repositoryOrder.readAll() == null || repositoryOrder.readAll().isEmpty()) {
            System.out.println(ERROR_READ_ALL_ORDERS);
            return null;
        } else if (idOrder < 0 || idOrder >= readAll().size()) {
            System.out.println(ERROR_INPUT);
            return null;
        }
        for (int i = 0; i <= readAll().size(); i++) {
            if (readAll().get(i).getIdOrder() == idOrder) {
                return repositoryOrder.read(i);
            }
        }
        System.out.println(ERROR_READ_ORDER);
        return null;
    }

    @Override
    // This method is not used in application.
    // All changes are processed in appropriate Services depending on Type of Hotel's Service.
    public boolean update(int idOrder, String orderUpdatingString) {
        if (repositoryOrder.readAll() == null || repositoryOrder.readAll().isEmpty()) {
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        } else if (read(idOrder) == null) {
            System.out.println(ERROR_READ_ORDER);
            System.out.println(ERROR_INPUT);
            return false;
        }
        Order orderUpdate = new Order(); // read from String
        return repositoryOrder.update(idOrder, orderUpdate);
    }

    @Override
    public boolean delete(int idOrder) {
        if (repositoryOrder.readAll() == null || repositoryOrder.readAll().isEmpty()) {
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        }
        for (int i = 0; i <= readAll().size(); i++) {
            if (readAll().get(i).getIdOrder() == idOrder) {
                return repositoryOrder.delete(i);
            }
        }
        System.out.println(ERROR_READ_ORDER);
        System.out.println(ERROR_INPUT);
        return false;
    }

    @Override
    public List<HotelService> readAllServicesSortByPrice(int idGuest) {
        return repositoryOrder.readAllServicesSortByPrice(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesSortByDate(int idGuest) {
        return repositoryOrder.readAllServicesSortByDate(idGuest);
    }

    @Override
    public List<HotelService> readAllServicesForGuest(int idGuest) {
        return repositoryOrder.readAllServicesForGuest(idGuest);
    }

    private int getIdOrderNew() {
        int lastId = readAll()
                .stream()
                .map(Order::getIdOrder)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        return lastId + 1;
    }

    private List<HotelService> readAllServicesForOrder(int idOrderNew) {
        return repositoryHotelService.readAll()
                .stream()
                .filter(o -> o.getIdOrder() == idOrderNew)
                .toList();
    }
}
