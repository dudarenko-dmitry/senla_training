package pl.senla.hotel.constant;

public class HotelFacilityConstant {

    private HotelFacilityConstant() {
    }

    public static final String READ_ALL_HOTEL_FACILITY_IS_EMPTY = "There is no any room in hotel.\n" +
                                                        "Please, check access to Database.";
    public static final String READ_HOTEL_FACILITY_NOT_EXIST =     "There is no such room in hotel.";

    public static final String READ_ALL_ROOM_IS_EMPTY = "There is no any room in hotel.\n" +
                                                        "Please, check access to Database.";
    public static final String ROOM_NOT_EXISTS =     "There is no such room in hotel.";

    public static final String ERROR_NULL_ID =              "Not allowed to create Facility without ID.";
    public static final String ERROR_NULL_CATEGORY =        "Not allowed to create Facility without Category.";
    public static final String ERROR_NAME_FACILITY =        "Not allowed to create Facility without name.";
    public static final String ERROR_NULL_CAPACITY =        "Not allowed to create Facility without number of Guests.";
    public static final String ERROR_NULL_PRICE =           "Not allowed to create Facility without price.";
    public static final String ERROR_NO_PERMISSION =        "You don't have permission to change RoomStatus.";
}
