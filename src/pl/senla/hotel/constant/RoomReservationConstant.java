package pl.senla.hotel.constant;

public class RoomReservationConstant {

    private RoomReservationConstant() {
    }

    public static final String ERROR_READ_ALL_ROOM_RESERVATION = "There are no any Room's Reservations.\n" +
                                                                "Please, check access to Database.";
    public static final String ERROR_CREATE_ROOM_RESERVATION =   "This Room's Reservation is already exist.";
    public static final String ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT = "Creating new Reservation is not available.\n" +
            "Please, create new Client or use existing Client.";
    public static final String ERROR_CREATE_ROOM_RESERVATION_NO_ROOM = "Creating new Reservation is not available.\n" +
            "Please, use existing Room.";
    public static final String ERROR_ROOM_NOT_AVAILABLE = "Creating new Reservation is not available.\n" +
            "Please, this Room is not FREE.";
    public static final String ERROR_READ_ROOM_RESERVATION =     "There is no such Room's reservation.";
}