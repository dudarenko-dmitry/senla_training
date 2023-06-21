package pl.senla.hotel.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.senla.hotel.constant.HotelConstant.*;

public class FreeRoom {

    private int idFreeRoom;
    private Room room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public FreeRoom(int idFreeRoom, Room room, LocalDate startDate, LocalDate endDate) {
        this.idFreeRoom = idFreeRoom;
        this.room = room;
        this.startTime = LocalDateTime.of(startDate, HOTEL_CHECK_OUT_TIME);
        this.endTime = LocalDateTime.of(endDate, HOTEL_CHECK_IN_TIME);
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
