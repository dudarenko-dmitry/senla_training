package pl.senla.hotel.utils;

import pl.senla.hotel.entity.CsvOrder;
import pl.senla.hotel.entity.Order;

import java.util.Arrays;

public final class OrderUtil {

    private OrderUtil() {
    }

    public static Order convertCsvToOrder(CsvOrder csvOrder) {
        Order order = new Order();
        order.setIdOrder(csvOrder.getIdOrder());
        order.setIdGuest(csvOrder.getIdGuest());
        String[] services = csvOrder.getServices()
                .split(",");
        order.setServices(Arrays.stream(services).map(Integer::parseInt).toList());
        return order;
    }
}
