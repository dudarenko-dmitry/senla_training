package pl.senla.hotel.utils;

import pl.senla.hotel.entity.Order;

import java.util.Arrays;
import java.util.List;

public final class OrderUtil {

    private OrderUtil() {
    }

//    public static Order convertCsvToOrder(CsvOrder csvOrder) {
//        Order order = new Order();
//        order.setIdOrder(csvOrder.getIdOrder());
//        order.setIdGuest(csvOrder.getIdGuest());
//        String[] services = csvOrder.getServices().split(","); // тут ошибка
////        String[] services = new String[] {"1","2"}; // такое читает правильно
//        order.setServices(Arrays.stream(services).map(Integer::parseInt).toList());
//        return order;
//    }

    public static Order convertStringToOrder(String csvOrder) {
        Order order = new Order();
        String[] text = csvOrder.split(";");
        order.setIdOrder(Integer.parseInt(text[0].substring(1, text[0].length() - 1)));
        order.setIdGuest(Integer.parseInt(text[1].substring(1, text[1].length() - 1)));
        String[] services = text[2].substring(1, text[2].length() - 1).split(",");
        List<Integer> idServices = Arrays.stream(services)
                .map(Integer::parseInt)
                .toList();
        order.setServices(idServices);
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
