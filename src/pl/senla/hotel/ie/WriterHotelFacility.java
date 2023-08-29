package pl.senla.hotel.ie;

import com.opencsv.CSVWriter;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.utils.RoomReservationUtil;

import java.io.*;
import java.util.List;

public class WriterHotelFacility implements Writer<HotelFacility> { // works only with Room.

    @Override
    public void save(List<HotelFacility> hotelFacilities) throws IOException {
        String filePathName = "D://Документы/Личка/IT/data/HotelFacility.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(filePathName),
                ';',
                '\'',
                '\\',
                "\n");
        String[] header = new String[]
                {"idFacility", "category", "nameFacility", "price", "capacity", "roomLevel", "roomStatus"};
        writer.writeNext(header);
        for (HotelFacility facility : hotelFacilities) {
            if (facility != null) {
                String[] textFacility = RoomReservationUtil.convertFacilityToString(facility);
                writer.writeNext(textFacility);
            }
        }
        System.out.println("Hotel's facilities (Room) were saved");
        writer.close();
    }
}
