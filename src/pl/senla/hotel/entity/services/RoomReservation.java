//package pl.senla.hotel.entity.services;
//
//import lombok.Getter;
//import lombok.Setter;
//import pl.senla.hotel.application.annotation.AppComponent;
//import pl.senla.hotel.application.annotation.GetInstance;
//import pl.senla.hotel.service.ServiceFacility;
//
//import java.io.Serial;
//import java.io.Serializable;
//import java.lang.reflect.InvocationTargetException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import static pl.senla.hotel.constant.HotelConstant.*;
//import static pl.senla.hotel.constant.HotelServiceConstant.*;
//import static pl.senla.hotel.constant.RoomReservationConstant.*;
//
//@AppComponent
//@Setter
//@Getter
//public class RoomReservation extends HotelService implements Serializable {
//
//    private Integer idRoom;
//    private Integer numberOfDays;
//    private LocalDateTime checkInTime;
//    private LocalDateTime checkOutTime;
//    private Integer cost;
//    @GetInstance(beanName = "ServiceFacilityDB")
//    private transient ServiceFacility serviceRoom;
//
//    @Serial
//    private static final long serialVersionUID = 10L;
//
//    public RoomReservation() {
//
//    }
//
//    public RoomReservation(ServiceFacility serviceRoom) {
//        this.serviceRoom = serviceRoom;
//    }
//
//    public RoomReservation(Integer idService, Integer idOrder, Integer idGuest, Integer idRoom,
//                           LocalDate startDate, Integer numberOfDays, ServiceFacility serviceRoom)
//            throws InvocationTargetException, NoSuchMethodException, InstantiationException,
//            IllegalAccessException {
//        super(idService, idOrder, TypeOfService.ROOM_RESERVATION, idGuest);
//        this.serviceRoom = serviceRoom;
//        if(idRoom == null){
//            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
//            return;
//        }
//        if(startDate == null){
//            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_DATE);
//            return;
//        }
//        if(numberOfDays == null){
//            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_DAYS);
//            return;
//        }
//        this.idRoom = idRoom;
//        this.numberOfDays = numberOfDays;
//        this.checkInTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
//        this.checkOutTime = LocalDateTime.of(startDate.plusDays(numberOfDays), HOTEL_CHECK_OUT_TIME);
//        this.cost = this.serviceRoom.read(idRoom).getPrice() * numberOfDays;
//    }
//
//    public void setIdRoom(Integer idRoom) {
//        if (idRoom != null) {
//            this.idRoom = idRoom;
//        } else {
//            System.out.println(ERROR_NULL_FACILITY);
//        }
//    }
//
//    public void setCheckInTime(LocalDateTime checkInTime) {
//        if (checkInTime != null) {
//            this.checkInTime = checkInTime;
//        } else {
//            System.out.println(ERROR_NULL_START_TIME);
//        }
//    }
//
//    public void setNumberOfDays(Integer numberOfDays) {
//        if (numberOfDays != null) {
//            this.numberOfDays = numberOfDays;
//        } else {
//            System.out.println(ERROR_NULL_DAYS);
//        }
//    }
//
//    public void setCheckOutTime(LocalDateTime checkOutTime) {
//        if (checkOutTime != null) {
//            this.checkOutTime = checkOutTime;
//        } else {
//            System.out.println(ERROR_NULL_END_TIME);
//        }
//    }
//
//    public void setCost(Integer cost) {
//        if (cost != null) {
//            this.cost = cost;
//        } else {
//            System.out.println(ERROR_NULL_COST);
//        }
//    }
//
//    // TODO
//    public void setCost() throws InvocationTargetException, NoSuchMethodException,
//            InstantiationException, IllegalAccessException {
//        if (cost != null) {
//            this.cost = getNumberOfDays() * serviceRoom.read(idRoom).getPrice();
//        } else {
//            System.out.println(ERROR_NULL_COST);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "\n == > HotelService {" +
//                "type of Service=" + super.getTypeOfService() +
//                ",idHotelService=" + super.getIdService() +
//                ", idGuest=" + super.getIdGuest() +
//                ", idRoom=" + idRoom +
//                ",\ncheck-in time=" + checkInTime +
//                ", numberOfDays=" + numberOfDays +
//                ", check-out time=" + checkOutTime +
//                ", cost=" + cost +
//                '}';
//    }
//}
