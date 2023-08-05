package pl.senla.hotel.ie;

import com.opencsv.CSVWriter;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;

import java.io.*;
import java.util.List;

public class WriterHotelFacility implements Writer<HotelFacility> {

    @Override
    public void save(List<HotelFacility> hotelFacilities) throws IOException {
        String filePathName = "D://HotelFacility.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(filePathName), ';', '\'', '\\', "\n");
        String[] header = new String[] {"id", "category", "nameFacility", "price", "capacity", "roomLevel", "roomStatus"};
        writer.writeNext(header);
        for (HotelFacility facility : hotelFacilities) {
            String[] textFacility = convertFacilityToString(facility);
            writer.writeNext(textFacility);
        }
        System.out.println("Hotel's facilities is saved");
        writer.close();
    }

    private String[] convertFacilityToString(HotelFacility facility) {
        int idFacility = facility.getIdFacility();
        String category = facility.getCategory();
        String nameFacility = facility.getNameFacility();
        int price = facility.getPrice();
        int capacity = facility.getCapacity();
        switch (category) {
            case "Room" -> {
                Room hsRoom = (Room) facility;
                String roomLevel = hsRoom.getRoomLevel();
                String roomStatus = hsRoom.getRoomStatus();
                return new String[] {
                        String.valueOf(idFacility),
                        category,
                        nameFacility,
                        String.valueOf(price),
                        String.valueOf(capacity),
                        roomLevel,
                        roomStatus
                };
            }
            case "Table" -> System.out.println("This Hotel Facility (Table) was not created.");
            case "Transport" -> System.out.println("This Hotel Facility (Transport) was not created.");
            default -> throw new IllegalStateException("Unexpected value: " + category);
        }
        return new String[0]; // change after creating of rest entities
    }
}
