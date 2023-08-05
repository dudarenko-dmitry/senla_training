package pl.senla.hotel.entity.services;

import pl.senla.hotel.service.ServiceRoom;
import pl.senla.hotel.service.ServiceRoomImpl;

import java.io.Serial;
import java.io.Serializable;

public class CsvRoomReservation extends HotelService implements Serializable {

    private int idRoom;
    private int numberOfDays;
    private String checkInTime;
    private String checkOutTime;
    private int cost;
    private final transient ServiceRoom serviceRoom = ServiceRoomImpl.getServiceRoom();

    @Serial
    private static final long serialVersionUID = 100L;

    public CsvRoomReservation() {
    }

    public CsvRoomReservation(int idService, int idOrder, TypeOfService typeOfService, int idGuest, int idRoom, String checkInTime, int numberOfDays, String checkOutTime, int cost) {
        super(idService, idOrder, TypeOfService.valueOf(typeOfService.name()), idGuest);
        this.idRoom = idRoom;
        this.numberOfDays = numberOfDays;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.cost = cost;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost() {
        this.cost = getNumberOfDays() * serviceRoom.read(idRoom).getPrice();
    }

    @Override
    public String toString() {
        return "CsvRoomReservation {" +
                "type of Service=" + super.getTypeOfService() +
                ",\nidRoomReservation=" + super.getIdService() +
                ", idGuest=" + super.getIdGuest() +
                ", idRoom=" + idRoom +
                ",\ncheck-in time=" + checkInTime +
                ", numberOfDays=" + numberOfDays +
                ", check-out time=" + checkOutTime +
                ", cost=" + cost +
                '}';
    }
}
