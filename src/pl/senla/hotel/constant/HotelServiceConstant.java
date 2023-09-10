package pl.senla.hotel.constant;

public class HotelServiceConstant {

    private HotelServiceConstant() {
    }

    public static final String ERROR_READ_ALL_SERVICES =    "There is no any service in hotel.\n" +
                                                            "Please, check access to Database.";
    public static final String ERROR_CREATE_SERVICE =       "This service is already exist.";
    public static final String ERROR_READ_SERVICE =         "There is no such service.";
    public static final String ERROR_IN_SERVICE_TYPE =      "ERROR IN SERVICE TYPE.";

    public static final String ERROR_NULL_ID =              "Not allowed to create Service without ID.";
    public static final String ERROR_NULL_CATEGORY =        "Not allowed to create Service without Category.";
    public static final String ERROR_NULL_ID_ORDER =        "Not allowed to create Service without IdOrder.";
    public static final String ERROR_NULL_FACILITY =        "Not allowed to create Service without idFacility.";
    public static final String ERROR_NULL_GUEST =           "Not allowed to create Service without Guest.";
    public static final String ERROR_NULL_NUMBER_OF_GUEST = "Not allowed to create Service without number of Guests.";
    public static final String ERROR_NULL_START_TIME =      "Not allowed to create Service without start-time.";
    public static final String ERROR_NULL_END_TIME =        "Not allowed to create Service without end-time.";
    public static final String ERROR_NULL_DAYS =            "Not allowed to create Service without time of usage.";
    public static final String ERROR_NULL_PRICE =           "Not allowed to create Service without price.";
    public static final String ERROR_NULL_COST =            "Not allowed to create Service without total cost.";
}
