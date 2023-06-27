package pl.senla.hotel.entity.facilities;

public class Room extends HotelFacility{

    private String roomLevel;
    private String roomStatus;

    public Room(String category, String nameFacility, int price, int capacity, String roomLevel, String roomStatus) {
        super(category, nameFacility, price, capacity);
        this.roomLevel = roomLevel;
        this.roomStatus = roomStatus;
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
//    idFacility
//    category
//    nameFacility
//    price
//    capacity

//    roomLevel
//    roomStatus
}
