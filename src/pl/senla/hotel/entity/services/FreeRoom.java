package pl.senla.hotel.entity.services;

import pl.senla.hotel.entity.facilities.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelConstant.*;

public class FreeRoom {

    private int idFreeRoom = -1;
    private Room room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public FreeRoom(Room room, LocalDate startDate, LocalDate endDate) {
        this.room = room;
        this.startTime = LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME);
        this.endTime = LocalDateTime.of(endDate, HOTEL_CHECK_OUT_TIME);
    }

    public FreeRoom(Room checkedRoomForFreeRoom, LocalDateTime checkOutTime, LocalDateTime checkedFreeRoomEndTime) {
        this.room = checkedRoomForFreeRoom;
        this.startTime = checkOutTime;
        this.endTime = checkedFreeRoomEndTime;
    }

    public int getIdFreeRoom() {
        return idFreeRoom;
    }

    public void setIdFreeRoom(int idFreeRoom) {
        this.idFreeRoom = idFreeRoom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "\nFreeRoom{" +
                "IdFreeRoomSlot=" + idFreeRoom +
                ", room=" + room +
                ", startDate=" + startTime +
                ", endDate=" + endTime +
                '}';
    }
}
