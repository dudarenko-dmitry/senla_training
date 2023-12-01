package pl.senla.hotel.utils;

import pl.senla.hotel.entity.facilities.*;

import java.util.Objects;

public final class RoomUtil {

    private RoomUtil() {
    }

    public static Room convertStringToRoom(String csvT) {
        String[] text = csvT.split(";");
        Room room = new Room();
        room.setIdFacility(Integer.valueOf(text[0].substring(1, text[0].length() - 1)));
        room.setCategory(CategoryFacility.valueOf(text[1].substring(1, text[1].length() - 1)));
        room.setNameFacility(text[2].substring(1, text[2].length() - 1));
        room.setPrice(Integer.valueOf(text[3].substring(1, text[3].length() - 1)));
        room.setCapacity(Integer.valueOf(text[4].substring(1, text[4].length() - 1)));
        room.setRoomLevel(RoomLevel.valueOf(text[5].substring(1, text[5].length() - 1)));
        room.setRoomStatus(RoomStatus.valueOf(text[6].substring(1, text[6].length() - 1)));
        return room;
    }

    public static String[] convertFacilityToString(Room facility) {
        Integer idFacility = facility.getIdFacility();
        CategoryFacility categoryFacility = facility.getCategory();
        String nameFacility = facility.getNameFacility();
        Integer price = facility.getPrice();
        Integer capacity = facility.getCapacity();
        if (Objects.requireNonNull(categoryFacility) == CategoryFacility.ROOM) {
            RoomLevel roomLevel = facility.getRoomLevel();
            RoomStatus roomStatus = facility.getRoomStatus();
            return new String[]{
                    String.valueOf(idFacility),
                    categoryFacility.name(),
                    nameFacility,
                    String.valueOf(price),
                    String.valueOf(capacity),
                    roomLevel.name(),
                    roomStatus.name()
            };
        }
        throw new IllegalStateException("Unexpected value: " + categoryFacility.name());
    }
}
