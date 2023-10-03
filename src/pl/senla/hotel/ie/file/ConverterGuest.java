package pl.senla.hotel.ie.file;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.utils.GuestUtil;

import static pl.senla.hotel.constant.PropertiesConstant.KEY_FILE_GUESTS_NAME;
import static pl.senla.hotel.constant.PropertiesConstant.KEY_FILE_PATH;

public class ConverterGuest implements ConverterEntity<Guest> {

    private final Configuration configuration;

    public ConverterGuest() {
        this.configuration = AppConfiguration.getAppConfiguration();
    }

    public String getPath() {
        return configuration.getStringProperty(KEY_FILE_PATH) + configuration.getStringProperty(KEY_FILE_GUESTS_NAME);
    }

    public String[] getHeader() {
        return new String[]{"idGuest", "name", "phoneNumber" };
    }

    public String[] convertEntityToString(Guest t) {
        return GuestUtil.convertGuestToString(t);
    }

    public Guest convertStringToEntity(String csvT) {
        return GuestUtil.convertStringToOrder(csvT);
    }
}
