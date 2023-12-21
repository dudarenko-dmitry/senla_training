package pl.senla.hotel.exceptions;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(Integer idRoom) {
        super("Could not find Room " + idRoom);
    }
}
