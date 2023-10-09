package pl.senla.hotel.ie.file;

import pl.senla.hotel.annotations.config.ConfigProperty;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;

import pl.senla.hotel.service.ServiceRoom;
import pl.senla.hotel.utils.RoomReservationUtil;

public class ConverterRoomReservation implements ConverterEntity<HotelService> {

    @GetInstance(beanName = "ServiceRoomImpl")
    private ServiceRoom serviceRoom;
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

    public RoomReservation convertStringToEntity(String csvT) {
        return RoomReservationUtil.convertCsvToRoomReservation(csvT, serviceRoom);
    }
}
