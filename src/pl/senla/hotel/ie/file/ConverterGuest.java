package pl.senla.hotel.ie.file;

import pl.senla.hotel.annotations.config.ConfigProperty;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.utils.GuestUtil;

public class ConverterGuest implements ConverterEntity<Guest> {

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-path.directory")
    private String filePathDirectory;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.guest")
    private String fileNameGuest;

    public String getPath() {
        return filePathDirectory + fileNameGuest;
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
