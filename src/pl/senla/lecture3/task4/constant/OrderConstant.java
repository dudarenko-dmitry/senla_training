package pl.senla.lecture3.task4.constant;

public class OrderConstant {

    private OrderConstant() {
    }

    public static final String ERROR_READ_ALL_ROOM = "There are no any orders.\n" +
                                                        "Please, check access to Database.";
    public static final String ERROR_CREATE_ROOM =   "This order is already exist.";
    public static final String ERROR_READ_ROOM =     "There is no such room in hotel.\n" +
                                                        "Please, check if room's ID correct.";

}
