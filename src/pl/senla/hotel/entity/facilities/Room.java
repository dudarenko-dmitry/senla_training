package pl.senla.hotel.entity.facilities;

import java.io.Serial;
import java.io.Serializable;

public class Room extends HotelFacility implements Serializable {

    private RoomLevel roomLevel;
    private RoomStatus roomStatus;

    @Serial
    private static final long serialVersionUID = 1L;

    public Room(CategoryFacility category, String nameFacility, Integer price, Integer capacity,
                RoomLevel roomLevel, RoomStatus roomStatus) {
        super(category, nameFacility, price, capacity);
        this.roomLevel = roomLevel;
        this.roomStatus = roomStatus;
    }

    public Room() {
        super();
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public RoomLevel getRoomLevel() {
        return roomLevel;
    }

    public void setRoomLevel(RoomLevel roomLevel) {
        this.roomLevel = roomLevel;
    }

    public void makeRoomAvailable() {
        roomStatus = RoomStatus.AVAILABLE;
    }

    public void makeRoomRepaired() {
        roomStatus = RoomStatus.REPAIRED;
    }

    @Override
    public String toString() {
        return "\nRoom{" +
                "roomId=" + super.getIdFacility() +
                ", category=" + super.getCategory() +
                ", roomNumber=" + super.getNameFacility() +
                ", roomPrice=" + super.getPrice() +
                ", capacity=" + super.getCapacity() +
                ", roomLevel=" + roomLevel +
                ", roomStatus=" + roomStatus +
                '}';
    }
}
