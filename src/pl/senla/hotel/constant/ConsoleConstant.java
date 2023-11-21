package pl.senla.hotel.constant;

public class ConsoleConstant {

    private ConsoleConstant() {
    }

    public static final String CONSOLE_READ_ALL_ROOMS =         "\nList of all rooms: {}";
    public static final String CONSOLE_READ_ROOM =              "Room: {}";
    public static final String CONSOLE_CREATE_ROOM =            "New room was created: {}";
    public static final String CONSOLE_CHANGE_ROOM =            "Room was changed: {}";
    public static final String CONSOLE_DELETE_ROOM =            "Room was deleted: {}";

    public static final String CONSOLE_READ_ALL_FREE_ROOMS =         "\nList of all Free rooms (Time-slots): ";
    public static final String CONSOLE_READ_ALL_FREE_ROOMS_TIME =    "\nList of all Free rooms at Time: {}";
    public static final String CONSOLE_NUMBER_OF_FREE_ROOMS =        "Number of Free rooms at {}: {}";

    public static final String CONSOLE_READ_ALL_ROOM_RESERVATIONS = "\nList of all room's reservations: ";
    public static final String CONSOLE_CHANGE_ROOM_RESERVATION =    "Room reservation was changed: ";
    public static final String CONSOLE_NUMBER_GUEST_IN_HOTEL_NOW =  "Number of Guest in Hotel at {}: {}} ";
    public static final String CONSOLE_GUEST_PAYMENT_FOR_ROOM =     "Guest's payment for the room: {}";

    public static final String CONSOLE_READ_ALL_GUESTS =            "\nList of Guests:{}";
    public static final String CONSOLE_READ_GUEST =                 "Guest: {}";
    public static final String CONSOLE_CREATE_GUEST =               "New Guest was created: {}";
    public static final String CONSOLE_CHANGE_GUEST =               "Guest was changed: {}";
    public static final String CONSOLE_DELETE_GUEST =               "Guest was deleted: {}";
    public static final String CONSOLE_NUMBER_GUEST_TOTAL =         "Total number of registered Guest in DataBase: {}";
    public static final String CONSOLE_3_GUESTS_AND_DATES =         "The last 3 guests of the room and the dates of their stay: {}";

    public static final String CONSOLE_READ_ALL_SERVICES =              "\nList of Services: {}";
    public static final String CONSOLE_READ_ALL_SERVICES_FOR_ORDER =    "\nList of all Services for Order: {}";
    public static final String CONSOLE_CREATE_SERVICE =                 "New Reservation was created: {}";

    public static final String CONSOLE_READ_ALL_FACILITIES =        "\nHotel's facilities' list: ";

    public static final String CONSOLE_READ_ALL_ORDERS = "\nList of Orders: {}";
    public static final String CONSOLE_CREATE_ORDER = "New Order was created: {}";
    public static final String CONSOLE_CHANGE_ORDER = "Order changed: {}";
    public static final String CONSOLE_DELETE_ORDER = "Order deleted: {}";

    public static final String CONSOLE_READ_ALL_ROOMS_SORTED_BY_PRICE =      "\nList of all rooms sorted by price: {}";
    public static final String CONSOLE_READ_FREE_ROOMS_SORTED_BY_PRICE =     "\nList of free rooms sorted by price: {}";
    public static final String CONSOLE_READ_ALL_SERVICES_SORTED_BY_PRICE =   "\nList of room's reservations sorted by price: {}";
    public static final String CONSOLE_READ_ALL_FACILITIES_SORTED_BY_PRICE = "\nList of HotelFacilities sorted by price: {}";
    public static final String CONSOLE_READ_ALL_SERVICES_SORTED_BY_DATE =    "\nList of room's reservations sorted by date: {}";
    public static final String CONSOLE_READ_ALL_ROOMS_SORTED_BY_CAPACITY =   "\nList of all rooms sorted by Room's capacity: {}";
    public static final String CONSOLE_READ_FREE_ROOMS_SORTED_BY_CAPACITY =  "\nList of free rooms sorted by Room's capacity: {}";
    public static final String CONSOLE_READ_ALL_ROOMS_SORTED_BY_LEVEL =      "\nList of all rooms sorted by Room's level: {}";
    public static final String CONSOLE_READ_ALL_FREE_ROOMS_SORTED_BY_LEVEL = "\nList of free rooms sorted by Room's level: {}";
    public static final String CONSOLE_READ_ALL_ROOM_RESERVATIONS_SORTED_BY_GUEST_NAME = "\nList of Guests sorted by name:{}";
    public static final String CONSOLE_READ_ALL_ROOM_RESERVATIONS_SORTED_BY_CHECK_OUT =  "\nList of Guests sorted by check-out time";
    public static final String CONSOLE_READ_ALL_FACILITIES_SORTED_BY_CATEGORY = "\nList of HotelFacilities sorted by category";

    public static final String INPUT_MENU_POINT =     "Input your choice --> ";
    public static final String ERROR_INPUT =          "ERROR!!!\nYou input is invalid. Please, repeat input/action.";
    public static final String INPUT_ID_GUEST =       "Input Guest's ID --> ";
    public static final String INPUT_ID_ROOM =        "Input Room's ID --> ";
    public static final String INPUT_ID_ROOM_UPDATE = "Input Room's ID to update --> ";
    public static final String INPUT_ID_RESERVATION_UPDATE = "Input RoomReservation's ID to Update --> ";
    public static final String INPUT_ID_ORDER =       "Input Order's ID --> ";

    public static final String SELECT_START_TIME =     "Select start Time of Reservation. ";
    public static final String INPUT_YEAR =            "Input year --> ";
    public static final String INPUT_MONTH =           "Input month --> ";
    public static final String INPUT_DAY =             "Input day --> ";
    public static final String INPUT_HOUR =            "Input hour --> ";
    public static final String INPUT_MINUTE =          "Input minute --> ";

    public static final String INPUT_GUEST_DATA =   "Input new Guest's data: ";
    public static final String INPUT_NAME =         "Guest's name --> ";
    public static final String INPUT_PHONE =        "Guest's phone number --> ";
    public static final String INPUT_NEW_PHONE =    "Input new phoneNumber --> ";

    public static final String INPUT_ROOM_DATA =            "Input new Room's data: ";
    public static final String INPUT_PRICE =                "Input new price --> ";
    public static final String INPUT_ROOM_NUMBER =          "Room number/name --> ";
    public static final String INPUT_CAPACITY =             "Capacity of Room --> ";

    public static final String INPUT_NUMBER_OF_DAYS = "Input number of days to reserve --> ";
    public static final String ADD_NEW_SERVICE_FOR_ORDER = "Add new services to order: {}";
    public static final String UPDATE_RESERVATION = "Update Room's Reservation: ";

}