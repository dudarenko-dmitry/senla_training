package pl.senla.hotel.entity.services;

public enum TypeOfService {
    ROOM_RESERVATION("RoomReservation"),
    RESTAURANT("Restaurant"),
    TRANSFER("Transfer");

    private final String typeName;

    TypeOfService(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
