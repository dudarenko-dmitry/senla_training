package pl.senla.hotel.service;

import pl.senla.hotel.comparators.HotelServicesComparatorByDate;
import pl.senla.hotel.comparators.HotelServicesComparatorByPrice;
import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.repository.*;
import pl.senla.hotel.ui.services.StartCreateHotelService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.OrderConstant.*;

public class ServiceOrderImpl implements ServiceOrder {

    private static ServiceOrder serviceOrder;
    private final ServiceCRUDALL<HotelService> serviceHotelService;
    private final Repository<Order> repositoryOrder;
    private final Repository<HotelService> repositoryHotelService;
    private final Repository<RoomReservation> repositoryRoomReservation;
    private final Configuration configuration;


    private ServiceOrderImpl(Configuration appConfiguration) {
        this.configuration = appConfiguration;
        this.serviceHotelService = ServiceHotelServiceImpl.getServiceHotelService(configuration);
        this.repositoryOrder = RepositoryOrderCollection.getRepositoryOrder();
        this.repositoryHotelService = RepositoryHotelServiceCollection.getRepositoryHotelService();
        this.repositoryRoomReservation = RepositoryRoomReservationCollection.getRepositoryRoomReservation();
    }

    public static ServiceOrder getServiceOrder(Configuration appConfiguration) {
        if (serviceOrder == null) {
            serviceOrder = new ServiceOrderImpl(appConfiguration);
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
        order.setIdGuest(idGuest);
        int idOrderNew = getIdOrderNew();
        order.setIdOrder(idOrderNew);
        StartCreateHotelService.getStartCreateHotelService(configuration).runMenu(idOrderNew, idGuest);
        List<Integer> idServicesInOrder = readAllIdServicesForOrder(idOrderNew);
        order.setServices(idServicesInOrder);
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
                List<HotelService> services = repositoryHotelService.readAll();
                for (int j = 0; j < services.size(); j++){
                    if (services.get(j).getIdOrder() == idOrder) {
                        repositoryRoomReservation.delete(j);
                        repositoryHotelService.delete(j);
                    }
                }
                return repositoryOrder.delete(i);
            }
        }
        System.out.println(ERROR_READ_ORDER);
        System.out.println(ERROR_INPUT);
        return false;
    }

    @Override
    public List<HotelService> readAllServicesSortByPrice() {
        return repositoryOrder.readAll()
                .stream()
                .flatMap(o -> o.getServices()
                        .stream()
                        .map(serviceHotelService::read))
                .sorted(new HotelServicesComparatorByPrice())
                .toList();
    }

    @Override
    public List<HotelService> readAllServicesSortByDate() {
        return repositoryOrder.readAll()
                .stream()
                .flatMap(o -> o.getServices()
                        .stream()
                        .map(serviceHotelService::read))
                .sorted(new HotelServicesComparatorByDate())
                .toList();
    }

    @Override
    public List<HotelService> readAllServicesForOrder(int idOrder) {
        System.out.println(("Orders: " + repositoryOrder.readAll()
                .stream()
                .filter(o -> o.getIdOrder() == idOrder)
                .flatMap(o -> o.getServices()
                        .stream()
                        .map(serviceHotelService::read))
                .toList()));
        return repositoryOrder.readAll()
                .stream()
                .filter(o -> o.getIdOrder() == idOrder)
                .flatMap(o -> o.getServices()
                        .stream()
                        .map(serviceHotelService::read))
                .toList();
    }

    private int getIdOrderNew() {
        int lastId = readAll()
                .stream()
                .map(Order::getIdOrder)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        return lastId + 1;
    }

    private List<Integer> readAllIdServicesForOrder(int idOrderNew) {
        return repositoryHotelService.readAll()
                .stream()
                .filter(o -> o.getIdOrder() == idOrderNew)
                .map(HotelService::getIdService)
                .toList();
    }
}
