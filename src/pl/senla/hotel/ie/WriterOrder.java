package pl.senla.hotel.ie;

import com.opencsv.CSVWriter;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.utils.OrderUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterOrder implements Writer<Order>{

    @Override
    public void save(List<Order> orders) throws IOException {
        String filePathName = "C://IT/Data/Orders.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(filePathName)
                ,';'
                ,'\''
                ,'\\'
                ,"\n"
                );
        String[] header = new String[] {"idOrder", "idGuest", "idServices"};
        writer.writeNext(header);
        for (Order o : orders) {
            if (o != null) {
                String[] textOrder = OrderUtil.convertOrderToString(o);
                writer.writeNext(textOrder);
            }
        }
        System.out.println("Orders' data were saved.");
        writer.close();
    }
}
