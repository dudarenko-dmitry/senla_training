package pl.senla.hotel.constant;

public class HotelFacilityConstant {

    private HotelFacilityConstant() {
    }

    public static final String ERROR_READ_ALL_HOTEL_FACILITY = "There is no any room in hotel.\n" +
                                                        "Please, check access to Database.";
    public static final String ERROR_CREATE_HOTEL_FACILITY =   "This room is already exits in hotel.";
    public static final String ERROR_READ_HOTEL_FACILITY =     "There is no such room in hotel.";

    public static final String ERROR_READ_ALL_ROOM = "There is no any room in hotel.\n" +
                                                        "Please, check access to Database.";
    public static final String ERROR_CREATE_ROOM =   "This room is already exits in hotel.";
    public static final String ERROR_READ_ROOM =     "There is no such room in hotel.";

}
