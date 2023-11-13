package pl.senla.hotel.entity.facilities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
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
