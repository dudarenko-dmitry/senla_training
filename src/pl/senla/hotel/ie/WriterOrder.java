package pl.senla.hotel.ie;

import com.opencsv.CSVWriter;
import pl.senla.hotel.entity.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterOrder implements Writer<Order>{

    @Override
    public void save(List<Order> orders) throws IOException {
        String filePathName = "D://Документы/Личка/IT/senla_training/src/pl/senla/hotel/data/Orders.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(filePathName),
                ';',
                '/',
                '\\',
                "\n");
        String[] header = new String[] {"idOrder", "idGuest", "idServices"};
        writer.writeNext(header);
        for (Order o : orders) {
            String[] textOrder = convertOrderToString(o);
            writer.writeNext(textOrder);
        }
        System.out.println("Orders' data were saved.");
        writer.close();
    }

    private String[] convertOrderToString(Order o) {
        String idOrder = String.valueOf(o.getIdOrder());
        String idGuest = String.valueOf(o.getIdGuest());
        List<Integer> idServices = o.getServices();
        StringBuilder services = new StringBuilder();
        services.append(idServices.get(0));
        if (idServices.size() > 1) {
            for (int i = 1; i <= idServices.size() - 1; i++) {
                services.append(",").append(idServices.get(i));
            }
        }
        return new String[] {idOrder, idGuest, String.valueOf(services)};
    }
}
