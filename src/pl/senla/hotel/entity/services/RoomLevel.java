package pl.senla.hotel.entity.services;

public enum RoomLevel {

    LUX("3***"),
    STANDART("2**"),
    ECONOM("1*");

    private final  String level;

    RoomLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
