package pl.senla.hotel.entity;

public enum RoomStatus {

    AVAILABLE("Available"),
    REPAIRED("Under repair");

    private final String status;

    RoomStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
