package pl.senla.hotel.exceptions;

public class GuestNotFoundException extends RuntimeException {

    public GuestNotFoundException(Integer idGuest) {
        super("Could not find Guest " + idGuest);
    }
}
