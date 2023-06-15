package pl.senla.lecture3.task4.entity;

public class Room {

    private int roomId;
    private int roomNumber;
    private int roomPrice;
    private int capacity;
    private String roomLevel;
    private String roomStatus;

    public Room() {
    }

    public Room(int roomId) {
        this.roomId = roomId;
    }

    public Room(int roomId, int roomNumber, int roomPrice, int capacity, String roomLevel, String roomStatus) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.capacity = capacity;
        this.roomLevel = roomLevel;
        this.roomStatus = roomStatus;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
                "roomId=" + roomId +
                ", roomNumber=" + roomNumber +
                ", roomPrice=" + roomPrice +
                ", capacity=" + capacity +
                ", roomLevel=" + roomLevel +
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
