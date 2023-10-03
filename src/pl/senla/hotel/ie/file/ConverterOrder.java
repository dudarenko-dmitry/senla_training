package pl.senla.hotel.ie.file;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.utils.OrderUtil;

import static pl.senla.hotel.constant.PropertiesConstant.KEY_FILE_ORDERS_NAME;
import static pl.senla.hotel.constant.PropertiesConstant.KEY_FILE_PATH;

public class ConverterOrder implements ConverterEntity<Order> {

    private final Configuration configuration;

    public ConverterOrder() {
        this.configuration = AppConfiguration.getAppConfiguration();
    }

    public String getPath() {
        return configuration.getStringProperty(KEY_FILE_PATH) + configuration.getStringProperty(KEY_FILE_ORDERS_NAME);
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
