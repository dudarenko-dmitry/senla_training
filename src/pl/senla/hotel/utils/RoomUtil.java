package pl.senla.hotel.utils;

import pl.senla.hotel.entity.facilities.*;

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

    public static String[] convertFacilityToString(HotelFacility facility) {
        Integer idFacility = facility.getIdFacility();
        CategoryFacility categoryFacility = facility.getCategory();
        String nameFacility = facility.getNameFacility();
        Integer price = facility.getPrice();
        Integer capacity = facility.getCapacity();
        switch (categoryFacility) {
            case ROOM -> {
                Room hsRoom = (Room) facility;
                RoomLevel roomLevel = hsRoom.getRoomLevel();
                RoomStatus roomStatus = hsRoom.getRoomStatus();
                return new String[] {
                        String.valueOf(idFacility),
                        categoryFacility.name(),
                        nameFacility,
                        String.valueOf(price),
                        String.valueOf(capacity),
                        roomLevel.name(),
                        roomStatus.name()
                };
            }
            case TABLE -> System.out.println("This Hotel Facility (Table) was not created.");
            case TRANSPORT -> System.out.println("This Hotel Facility (Transport) was not created.");
            default -> throw new IllegalStateException("Unexpected value: " + categoryFacility.name());
        }
        return new String[0]; // change after creating of rest entities
    }
}
