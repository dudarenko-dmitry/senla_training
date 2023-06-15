package pl.senla.lecture3.task4.constant;

public class ClientConstant {

    private ClientConstant() {
    }

    public static final String ERROR_READ_ALL_CLIENT = "There are no Clients in your Database.\n" +
                                                        "Please, check access to Database.";
    public static final String ERROR_CREATE_CLIENT =   "This Client is already exits.";
    public static final String ERROR_READ_CLIENT =     "There is no such Client.\n" +
                                                       "Please, check if Client's ID correct.";

}
