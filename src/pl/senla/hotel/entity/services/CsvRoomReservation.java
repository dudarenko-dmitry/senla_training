package pl.senla.hotel.entity.services;

import pl.senla.hotel.service.ServiceRoom;
import pl.senla.hotel.service.ServiceRoomImpl;

import java.io.Serial;
import java.io.Serializable;

public class CsvRoomReservation implements Serializable {

    private Integer idService;
    private Integer idOrder;
    private TypeOfService typeOfService;
    private Integer idGuest;
    private Integer idRoom;
    private Integer numberOfDays;
    private String checkInTime;
    private String checkOutTime;
    private Integer cost;
    private final transient ServiceRoom serviceRoom = ServiceRoomImpl.getServiceRoom();

    @Serial
    private static final long serialVersionUID = 100L;

    public CsvRoomReservation() {
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getIdService() {
        return idService;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }

    public Integer getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Integer idGuest) {
        this.idGuest = idGuest;
    }
}
