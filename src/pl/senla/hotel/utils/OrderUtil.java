package pl.senla.hotel.utils;

import pl.senla.hotel.entity.CsvOrder;
import pl.senla.hotel.entity.Order;

import java.util.Arrays;
import java.util.List;

public final class OrderUtil {

    private OrderUtil() {
    }

    public static Order convertCsvToOrder(CsvOrder csvOrder) {
        Order order = new Order();
        order.setIdOrder(csvOrder.getIdOrder());
        order.setIdGuest(csvOrder.getIdGuest());
        String[] services = csvOrder.getServices().split(","); // тут ошибка
//        String[] services = new String[] {"1","2"}; // такое читает правильно
        order.setServices(Arrays.stream(services).map(Integer::parseInt).toList());
        return order;
    }

    public static String[] convertOrderToString(Order o) {
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
