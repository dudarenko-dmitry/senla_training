package pl.senla.hotel.exceptions;

public class HotelServiceNotFoundException extends RuntimeException {

    public HotelServiceNotFoundException(Integer idHotelService) {
        super("Could not find HotelService " + idHotelService);
    }
}
