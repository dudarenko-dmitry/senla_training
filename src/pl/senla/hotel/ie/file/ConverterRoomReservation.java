package pl.senla.hotel.ie.file;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.services.HotelService;

import pl.senla.hotel.service.ServiceFacility;
import pl.senla.hotel.utils.RoomReservationUtil;

@AppComponent
public class ConverterRoomReservation implements ConverterEntity<HotelService> {

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-path.directory")
    private String filePathDirectory;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.services")
    private String fileNameServices;

    public ConverterRoomReservation() {
    }

    public String getPath() {
        return filePathDirectory + fileNameServices;
    }

    public String[] getHeader() {
        return new String[]{"idService", "idOrder", "typeOfService", "idGuest", "idRoom",
                "checkInTime", "numberOfDays", "checkOutTime", "cost"};
    }

    public String[] convertEntityToString(HotelService t) {
        return RoomReservationUtil.convertHotelServiceToString(t);
    }

    public HotelService convertStringToEntity(String csvT) {
        return RoomReservationUtil.convertCsvToRoomReservation(csvT);
    }
}
