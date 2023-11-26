package pl.senla.hotel.constant;

public class RestaurantConstant {

    private RestaurantConstant() {
    }

    public static final String ERROR_READ_ALL_RESTAURANT_RESERVATION = "There are no any Reservations in Restaurant.\n" +
                                                                       "Please, check access to Database.";
    public static final String ERROR_CREATE_RESTAURANT_RESERVATION =   "This Reservation in Restaurant is already exist.";
    public static final String ERROR_CREATE_RESTAURANT_RESERVATION_NO_CLIENT = "Creating new Reservation is not available.\n" +
            "Please, create new Client or use existing Client.";
    public static final String ERROR_CREATE_RESTAURANT_RESERVATION_NO_TABLE = "Creating new Reservation is not available.\n" +
            "Please, use existing Table.";
    public static final String ERROR_RESTAURANT_NOT_AVAILABLE = "Creating new Reservation is not available.\n" +
            "Please, this Table is not FREE.";
    public static final String ERROR_READ_RESTAURANT_RESERVATION =     "There is no such Reservation in Restaurant .";
}
