package pl.senla.lecture3.task4.entity;

public class Room {

    private int roomId;
    private int roomNumber;
    private int roomPrice;
    private String roomStatus;

    public Room() {
    }

    public Room(int roomId) {
        this.roomId = roomId;
    }

    public Room(int roomId, int roomNumber, int roomPrice, String roomStatus) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
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

    @Override
    public String toString() {
        return "\nRoom{" +
                "roomId=" + roomId +
                ", roomNumber=" + roomNumber +
                ", roomPrice=" + roomPrice +
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
