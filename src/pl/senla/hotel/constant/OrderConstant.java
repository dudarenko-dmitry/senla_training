package pl.senla.hotel.constant;

public class OrderConstant {

    private OrderConstant() {
    }

    public static final String ERROR_READ_ALL_ORDERS = "There are no any Orders.\n" +
                                                        "Please, check access to Database.";
    public static final String ERROR_CREATE_ORDER =   "Order with such ID is already exist.";
    public static final String ERROR_CREATE_ORDER_NO_CLIENT = "Creating new Order is not available.\n" +
            "Please, create new Client or use existing Client.";
    public static final String ERROR_CREATE_ORDER_NO_SERVICES = "Creating new Order is not available.\n" +
            "Please, create firstly Reservation for any HotelService.";
    public static final String ERROR_READ_ORDER =     "There is no such ORDER in Database.";

}
