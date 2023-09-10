package pl.senla.hotel.constant;

public class ClientConstant {

    private ClientConstant() {
    }

    public static final String ERROR_READ_ALL_CLIENT = "There are no Clients in your Database.\n" +
                                                        "Please, check access to Database.";
    public static final String ERROR_CREATE_CLIENT =   "This Client is already exits.";
    public static final String ERROR_READ_CLIENT =     "There is no such Client.";
    public static final String ERROR_NULL_ID =         "Not allowed to create Guest without ID.";
    public static final String ERROR_NULL_NAME =       "Not allowed to create Guest without name.";
    public static final String ERROR_NULL_PHONE =      "Not allowed to create Guest without name.";
}
