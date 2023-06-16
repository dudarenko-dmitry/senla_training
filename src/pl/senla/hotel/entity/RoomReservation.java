package pl.senla.hotel.entity;

import java.time.LocalDate;

import static pl.senla.hotel.constant.RoomReservationConstant.ERROR_CREATE_ROOM_RESERVATION_NO_ROOM;
import static pl.senla.hotel.constant.RoomReservationConstant.ERROR_ROOM_NOT_AVAILABLE;

public class RoomReservation extends HotelService{

    private Room room;
    private int numberOfDays;
    private int cost;

    public RoomReservation(int idHotelService) {
        super(idHotelService);
    }

    public RoomReservation(int idHotelService, LocalDate startDate, Client client, Room room, int numberOfDays) {
        super(idHotelService, startDate, client);
        if(room == null){// check if the ROOM exists
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_ROOM);
            return;
        } else if(!room.getRoomStatus().equals(RoomStatus.FREE.getStatus())){// check if the ROOM is FREE
            System.out.println(ERROR_ROOM_NOT_AVAILABLE);
            return;
        }
        room.setRoomStatus(RoomStatus.RESERVED.getStatus());
        this.room = room;
        this.numberOfDays = numberOfDays;
        this.cost = room.getRoomPrice() * numberOfDays;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return "RoomReservation{" +
                super.toString() +
                room +
                ",\nnumberOfDays=" + numberOfDays +
                ", cost=" + cost +
                '}';
    }
}
