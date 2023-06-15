package pl.senla.lecture3.task4.constant;

public class RoomReservationConstant {

    private RoomReservationConstant() {
    }

    public static final String ERROR_READ_ALL_ROOM_RESERVATION = "There are no any room's reservations.\n" +
                                                                "Please, check access to Database.";
    public static final String ERROR_CREATE_ROOM_RESERVATION =   "This room's reservation is already exist.";
    public static final String ERROR_READ_ROOM_RESERVATION =     "There is no such room's reservation.\n" +
                                                                 "Please, check if room's reservations ID correct.";

}
