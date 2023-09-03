package pl.senla.hotel.ie;

import com.opencsv.CSVWriter;
import pl.senla.hotel.entity.Guest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterGuest implements Writer<Guest>{

    @Override
    public void save(List<Guest> guests) throws IOException {
        String filePathName = "C://IT/Data/Guests.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(filePathName),
                ';',
                '\'',
                '\\',
                "\n");
        String[] header = new String[] {"idGuest", "name", "phoneNumber"};
        writer.writeNext(header);
        for (Guest g : guests) {
            if (g != null) {
                String[] guest = new String[]
                        {String.valueOf(g.getIdGuest()),
                                g.getName(),
                                String.valueOf(g.getPhoneNumber())};
                writer.writeNext(guest);
            }
        }
        System.out.println("Guests' data were saved.");
        writer.close();
    }
}
