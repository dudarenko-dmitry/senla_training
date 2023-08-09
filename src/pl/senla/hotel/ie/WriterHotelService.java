package pl.senla.hotel.ie;

import com.opencsv.CSVWriter;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterHotelService implements Writer<HotelService> { // works only with RoomReservation.

    @Override
    public void save(List<HotelService> hotelServices) throws IOException {
        String filePathName = "D://Документы/Личка/IT/senla_training/src/pl/senla/hotel/data/HotelServices.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(filePathName),
                ';',
                '\'',
                '\\',
                "\n");
        String[] header = new String[]
                {"idService", "idOrder", "typeOfService", "idGuest",
                        "idRoom", "checkInTime", "numberOfDays", "checkOutTime", "cost"};
        writer.writeNext(header);
        for (HotelService hs : hotelServices) {
            String[] textService = convertHotelServiceToString(hs);
            writer.writeNext(textService);
        }
        System.out.println("Hotel Services' data were saved.");
        writer.close();
    }

    private String[] convertHotelServiceToString(HotelService hs) {
        String idService = String.valueOf(hs.getIdService());
        String idOrder = String.valueOf(hs.getIdOrder());
        String typeOfService = hs.getTypeOfService();
        String idGuest = String.valueOf(hs.getIdGuest());
        switch (typeOfService) {
            case "RoomReservation" -> {
                RoomReservation hsReservation = (RoomReservation) hs;
                String idRoom = String.valueOf(hsReservation.getIdRoom());
                String checkInTime = String.valueOf(hsReservation.getCheckInTime());
                String numberOfDays = String.valueOf(hsReservation.getNumberOfDays());
                String checkOutTime = String.valueOf(hsReservation.getCheckOutTime());
                String cost = String.valueOf(hsReservation.getCost());
                return new String[] {
                        idService,
                        idOrder,
                        typeOfService,
                        idGuest,
                        idRoom,
                        checkInTime,
                        numberOfDays,
                        checkOutTime,
                        cost
                };
            }
            case "Restaurant" -> System.out.println("This Hotel Service (Restaurant) was not created.");
            case "Transfer" -> System.out.println("This Hotel Service (Transfer) was not created.");
            default -> throw new IllegalStateException("Unexpected value: " + typeOfService);
        }
        return new String[0]; // change after creating of rest services
    }
}
