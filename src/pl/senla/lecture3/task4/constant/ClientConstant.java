package pl.senla.lecture3.task4.constant;

public class ClientConstant {

    private ClientConstant() {
    }

    public static final String ERROR_READ_ALL_CLIENT = "There is no Clients in your DataStorage.\n" +
                                                        "Please, check access to DataStorage.";
    public static final String ERROR_CREATE_CLIENT =   "This Client is already exits.";
    public static final String ERROR_READ_CLIENT =     "There is no such Client.\n" +
                                                       "Please, check if Client's ID correct.";

}
