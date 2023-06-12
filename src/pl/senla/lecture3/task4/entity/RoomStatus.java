package pl.senla.lecture3.task4.entity;

public enum RoomStatus {

    FREE("Room is free."),
    RESERVED("Room is reserved."),
    REPAIRED("Room is under repair.");

    private final String status;

    RoomStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
