package pl.senla.hotel.service;

import org.apache.commons.lang3.StringUtils;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.repository.RepositoryOrder;
import pl.senla.hotel.repository.RepositoryOrderCollection;
import pl.senla.hotel.repository.RepositoryRoomReservation;
import pl.senla.hotel.repository.RepositoryRoomReservationCollection;

import java.util.ArrayList;
import java.util.List;

import static pl.senla.hotel.constant.OrderConstant.*;

public class ServiceOrderImpl implements ServiceOrder {

    private final RepositoryOrder repositoryOrder;
    private final RepositoryRoomReservation repositoryRoomReservation;

    public ServiceOrderImpl() {
        this.repositoryRoomReservation = new RepositoryRoomReservationCollection();
        this.repositoryOrder = new RepositoryOrderCollection();
    }

    @Override
    public List<Order> readAll() {
        if(repositoryOrder.readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
        }
        return repositoryOrder.readAll();
    }

    @Override
    public boolean create(String orderString) {
        String[] orderData = orderString.split(":");
        Order order = new Order();
        order.setIdOrder(-1);
        order.setIdGuest(Integer.parseInt(orderData[0]));
        List<HotelService> servicesInOrder = new ArrayList<>();
        String[] listOfServices = orderData[1].split("},");
        for(String s : listOfServices){
            String[] serviceData = s.split(", ");
            String typeOfService = StringUtils.substringAfter(serviceData[0], "=");
            if(typeOfService.equals(TypeOfService.ROOM_RESERVATION.getTypeName())){
                RoomReservation roomReservation = new RoomReservation();

//    public RoomReservation(int idGuest, int idRoom, LocalDate startDate, int numberOfDays) {
//                    super(TypeOfService.ROOM_RESERVATION.getTypeName(), idGuest);
//                    this.idRoom = idRoom;
//                    this.numberOfDays = numberOfDays;
//                    this.checkInTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
//                    this.checkOutTime = LocalDateTime.of(startDate.plusDays(numberOfDays), HOTEL_CHECK_OUT_TIME);
////        this.cost = idRoom.getPrice() * numberOfDays; // REFACTOR !!!!!!!!!!!!!!!!!!!!!!!!!!
//                    this.cost = 1000000000;
//                }

            } else if (typeOfService.equals(TypeOfService.RESTAURANT.getTypeName())){
                //logic-restaurant
            } else if (typeOfService.equals(TypeOfService.TRANSFER.getTypeName())){
                //logic-transfer
            }

        }
//        order.setServices();
        setIdOrderNew(order);
        return repositoryOrder.create(order);
    }

    @Override
    public Order read(int id) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return null;
        } else if(repositoryOrder.read(id) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return repositoryOrder.read(id);
    }

    @Override
    // This method is not used in application.
    // All changes are processed in appropriate Services depending on Type of Hotel's Service.
    public boolean update(int idOrder, String orderUpdatingString) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        } else if(read(idOrder) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return repositoryOrder.update(-1, null);
    }

    @Override
    public boolean delete(int id) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ORDERS);
            return false;
        } else if(read(id) == null){
            System.out.println(ERROR_READ_ORDER);
        }
        return repositoryOrder.delete(id);
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

    private void setIdOrderNew(Order order) {
        int lastId = readAll()
                .stream()
                .map(Order::getIdOrder)
                .max((o1, o2) -> o1 - o2)
                .orElse(-1);
        order.setIdOrder(lastId + 1);
    }
}
