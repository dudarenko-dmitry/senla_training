package pl.senla.hotel.entity.facilities;

public enum CategoryFacility {
    ROOM("Room"),
    TABLE("Table"),
    TRANSPORT("Transport");

    private final String typeName;

    CategoryFacility(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
