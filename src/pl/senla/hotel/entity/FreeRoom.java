package pl.senla.hotel.entity;

import java.time.LocalDate;

public class FreeRoom {

    private int idFreeRoom;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public FreeRoom(int idFreeRoom, Room room, LocalDate startDate, LocalDate endDate) {
        this.idFreeRoom = idFreeRoom;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "\nFreeRoom{" +
                "IdFreeRoomSlot=" + idFreeRoom +
                ", room=" + room +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
