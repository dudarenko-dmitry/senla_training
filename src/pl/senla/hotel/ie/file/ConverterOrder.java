package pl.senla.hotel.ie.file;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.utils.OrderUtil;

public class ConverterOrder implements ConverterEntity<Order> {

    private final Configuration configuration;

    public ConverterOrder() {
        this.configuration = AppConfiguration.getAppConfiguration();
    }

    public String getPath() {
        return configuration.getValueFilePath() + configuration.getValueFileOrdersName();
    }

    public String[] getHeader() {
        return new String[]{"idOrder", "idGuest", "idServices"};
    }

    public String[] convertEntityToString(Order t) {
        return OrderUtil.convertOrderToString(t);
    }

    public Order convertStringToEntity(String csvT) {
        return OrderUtil.convertStringToOrder(csvT);
    }
}
