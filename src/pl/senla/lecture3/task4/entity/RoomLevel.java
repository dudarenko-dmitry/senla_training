package pl.senla.lecture3.task4.entity;

public enum RoomLevel {

    LUX("Lux"),
    STANDART("Standart"),
    ECONOM("Econom");

    private final  String level;

    RoomLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
