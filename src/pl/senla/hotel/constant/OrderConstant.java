package pl.senla.hotel.constant;

public class OrderConstant {

    private OrderConstant() {
    }

    public static final String READ_ALL_ORDERS_IS_EMPTY = "There are no any Orders.\n" +
                                                        "Please, check access to Database.";
    public static final String ERROR_CREATE_ORDER_NO_CLIENT = "Creating new Order is not available.\n" +
            "Please, create new Client or use existing Client.";
    public static final String ORDER_NOT_EXISTS =      "There is no such ORDER in Database.";
    public static final String ERROR_EMPTY_ORDER =     "There is no any reservations in ORDER.";
    public static final String ERROR_ID_ORDER =        "Not allowed to create Order without IdOrder.";
    public static final String ERROR_ID_GUEST =        "Not allowed to create Order without IdGuest.";
    public static final String ERROR_ID_SERVICES =     "Not allowed to create Order without IdServices.";
}
