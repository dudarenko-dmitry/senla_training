package pl.senla.hotel.constant;

public class MenuConstant {

    public static final String MENU_MAIN =                             "\n<<<<< Welcome to Hotel >>>>>";
    public static final String MENU_ITEM_0_CLOSE_APPLICATION =         "0. Quit from program.";
    public static final String MENU_ITEM_1_HOTEL_FACILITY_OPERATIONS = "1. Hotel facilities operations.";
    public static final String MENU_ITEM_2_GUEST_OPERATIONS =          "2. Guests operations.";
    public static final String MENU_ITEM_3_ORDER_OPERATIONS =          "3. Orders' operations.";
    public static final String MENU_ITEM_4_ANALYTICS_REPORTS =         "4. Analytics reports.";
    public static final String MENU_ITEM_5_INPUT_OUTPUT =              "5. Input/Output Operations.";

    public static final String MENU_ITEM_0_QUIT_TO_MAIN =              "0. Quit to Main menu.";

    public static final String MENU_HOTEL_FACILITY =                   "\n===== Menu Hotel Facilities =====";
    public static final String MENU_ITEM_1_ROOM_OPERATION =            "1. Room operations.";
    public static final String MENU_ITEM_2_TABLE_OPERATION =           "2. Table operations. (DO NOT USE)";
    public static final String MENU_ITEM_3_TRANSPORT_OPERATION =       "3. Transport operations. (DO NOT USE)";

    public static final String MENU_ROOM =                             "\n===== Menu Rooms =====";
    public static final String MENU_ITEM_1_READ_ALL_ROOMS =            "1. Read all Rooms.";
    public static final String MENU_ITEM_2_READ_ROOM =                 "2. Read Room.";
    public static final String MENU_ITEM_3_CREATE_ROOM =               "3. Create new Room.";
    public static final String MENU_ITEM_4_UPDATE_ROOM =               "4. Update Room.";
    public static final String MENU_ITEM_5_DELETE_ROOM =               "5. Delete Room.";

    public static final String MENU_ROOM_LEVEL =                       "\n Rooms' levels: ";
    public static final String MENU_ROOM_1 =                           "1. Economy 1*";
    public static final String MENU_ROOM_2 =                           "2. Standard 2**";
    public static final String MENU_ROOM_3 =                           "3. Lux 3***";

    public static final String MENU_GUEST =                            "\n===== Menu Guests =====";
    public static final String MENU_ITEM_1_READ_ALL_GUESTS =           "1. Read all Guests.";
    public static final String MENU_ITEM_2_READ_GUEST =                "2. Read Guest.";
    public static final String MENU_ITEM_3_CREATE_GUEST =              "3. Create new Guest.";
    public static final String MENU_ITEM_4_UPDATE_GUEST =              "4. Update Guest.";
    public static final String MENU_ITEM_5_DELETE_GUEST =              "5. Delete Guest.";

    public static final String MENU_ORDER =                            "\n===== Menu Orders =====";
    public static final String MENU_ITEM_1_READ_ALL_ORDERS =           "1. Read all Order.";
    public static final String MENU_ITEM_2_READ_ORDER =                "2. Read Order.";
    public static final String MENU_ITEM_3_CREATE_ORDER =              "3. Create new Order.";
    public static final String MENU_ITEM_4_UPDATE_ORDER =              "4. Update Order.";
    public static final String MENU_ITEM_5_DELETE_ORDER =              "5. Delete Order.";

    public static final String MENU_INPUT_OUTPUT =                         "\n===== Data's Import-Export =====";
    public static final String MENU_ITEM_1_IMPORT_ALL_DATA =               "1. Import (load) all application's Entities from file (use after START application).";
    public static final String MENU_ITEM_2_EXPORT_ALL_DATA =               "2. Export (save) all application's Entities to file (use before EXIT application).";
    public static final String MENU_ITEM_3_IMPORT_ROOM_DATA =              "3. Import (load) Rooms' information from file (works only for Hotel Facility - ROOM).";
    public static final String MENU_ITEM_4_EXPORT_ROOM_DATA =              "4. Export (save) Rooms' information from file (works only for Hotel Facility - ROOM).";
    public static final String MENU_ITEM_5_IMPORT_GUEST_DATA =             "5. Import (load) Guests' information from file.";
    public static final String MENU_ITEM_6_EXPORT_GUEST_DATA =             "6. Export (save) Guests' information to file.";
    public static final String MENU_ITEM_7_IMPORT_SERVICE_AND_ORDER_DATA = "7. Import (load) Orders' and Services' information from file.";
    public static final String MENU_ITEM_8_EXPORT_SERVICE_AND_ORDER_DATA = "8. Export (save) Orders' and Services' (RoomReservation only) information to file.";

    public static final String MENU_HOTEL_SERVICE =                        "\n===== Hotel Services =====";
    public static final String MENU_ITEM_0_QUIT_TO_ORDER_MENU =            "0. Save List and Quit to Order menu.";
    public static final String MENU_ITEM_1_ROOM_RESERVATION =              "1. Room Reservation.";
    public static final String MENU_ITEM_2_RESTAURANT_RESERVATION =        "2. Restaurant Reservation. (DO NOT USE)";
    public static final String MENU_ITEM_3_TRANSFER_RESERVATION =          "3. Transfer Reservation. (DO NOT USE)";
    public static final String MENU_HOTEL_SERVICE_SELECT =                 "Select type of Hotel's Service you want to update.";

    public static final String MENU_ANALYTICS_REPORTS =                        "\n===== Menu Analytics Reports =====";
    public static final String MENU_ITEM_1_SORT_ROOMS_BY_PRICE =               "1. List of rooms sort by price.";
    public static final String MENU_ITEM_2_SORT_ROOMS_BY_CAPACITY =            "2. List of rooms by capacity.";
    public static final String MENU_ITEM_3_SORT_ROOMS_BY_LEVEL =               "3. List of rooms by number of stars.";
    public static final String MENU_ITEM_4_SORT_AVAILABLE_ROOMS_BY_PRICE =     "4. List of available rooms sort " +
            "by price.";
    public static final String MENU_ITEM_5_SORT_AVAILABLE_ROOMS_BY_CAPACITY =  "5. List of available rooms sort " +
            "by capacity.";
    public static final String MENU_ITEM_6_SORT_AVAILABLE_ROOMS_BY_LEVEL =     "6. List of available rooms sort " +
            "by number of stars.";
    public static final String MENU_ITEM_7_GUESTS_SORTED_BY_NAME_AND_ROOMS =   "7. List of guests and their rooms " +
            "sort alphabetically.";
    public static final String MENU_ITEM_8_GUESTS_AND_ROOMS_SORTED_BY_CHECK_OUT =       "8. List of guests" +
            " and their rooms sort by check-out date.";
    public static final String MENU_ITEM_9_COUNT_AVAILABLE_ROOMS =             "9. Total number of available rooms.";
    public static final String MENU_ITEM_10_COUNT_GUESTS =                     "10. Total number of guests.";
    public static final String MENU_ITEM_11_COUNT_GUESTS_ON_DATE =             "11. Total number of guests on date.";
    public static final String MENU_ITEM_12_AVAILABLE_ROOMS_ON_DATE =          "12. List of rooms that is available" +
            " on date.";
    public static final String MENU_ITEM_13_PAYMENT_OF_GUEST =                 "13. Payment for the room to be paid" +
            " by the guest.";
    public static final String MENU_ITEM_14_LAST_GUEST_FOR_ROOM_AND_DATES =    "14. Last 3 guests of the room and" +
            " the dates of their stay.";
    public static final String MENU_ITEM_15_LIST_OF_SERVICES_SORTED_BY_PRICE = "15. List of Guest's Services" +
            " and their price sort by price.";
    public static final String MENU_ITEM_16_LIST_OF_SERVICES_SORTED_BY_DATE =  "16. List of Guest's Services" +
            " and their price sort by date.";
    public static final String MENU_ITEM_17_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_CATEGORY =  "17. Prices of services" +
            " and rooms sort by category.";
    public static final String MENU_ITEM_18_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_PRICE =     "18. Prices of services" +
            " and rooms sort by price.";
    public static final String MENU_ITEM_19_ROOM_INFORMATION =                 "19. Read separate room" +
            " (WHAT DOES IT MEAN???).";

}
