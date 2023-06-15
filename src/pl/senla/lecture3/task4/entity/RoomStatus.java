package pl.senla.lecture3.task4.entity;

public enum RoomStatus {

    FREE("Free"),
    RESERVED("Reserved"),
    OCCUPIED("Occupied"),
    REPAIRED("Under repair");

    private final String status;

    RoomStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
