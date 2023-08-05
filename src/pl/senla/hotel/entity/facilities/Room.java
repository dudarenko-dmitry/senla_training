package pl.senla.hotel.entity.facilities;

import java.io.Serial;
import java.io.Serializable;

public class Room extends HotelFacility implements Serializable {

    private String roomLevel;
    private String roomStatus;

    @Serial
    private static final long serialVersionUID = 1L;

    public Room(String category, String nameFacility, int price, int capacity, String roomLevel, String roomStatus) {
        super(category, nameFacility, price, capacity);
        this.roomLevel = roomLevel;
        this.roomStatus = roomStatus;
    }

    public Room() {
        super();
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomLevel() {
        return roomLevel;
    }

    public void setRoomLevel(String roomLevel) {
        this.roomLevel = roomLevel;
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
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
