package pl.senla.hotel.ie.file;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.utils.OrderUtil;

@AppComponent
public class ConverterOrder implements ConverterEntity<Order> {

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-path.directory")
    private String filePathDirectory;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.order")
    private String fileNameOrder;

    public String getPath() {
        return filePathDirectory + fileNameOrder;
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
