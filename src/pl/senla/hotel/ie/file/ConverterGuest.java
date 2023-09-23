package pl.senla.hotel.ie.file;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.utils.GuestUtil;

public class ConverterGuest implements ConverterEntity<Guest> {

    private final Configuration configuration;

    public ConverterGuest() {
        this.configuration = AppConfiguration.getAppConfiguration();
    }

    public String getPath() {
        return configuration.getValueFilePath() + configuration.getValueFileGuestsName();
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
