package pl.senla.hotel.constant;

public class MenuConstant {

    public static final String MENU_MAIN =                             "\t\t\t<<<<< Welcome to Hotel >>>>>";
    public static final String MENU_ITEM_0_CLOSE_APPLICATION =         "\t\t\t0. Quit from program.";
    public static final String MENU_ITEM_1_HOTEL_FACILITY_OPERATIONS = "\t\t1. Hotel facilities operations.";
    public static final String MENU_ITEM_2_GUEST_OPERATIONS =          "\t\t\t2. Guests operations.";
    public static final String MENU_ITEM_3_ORDER_OPERATIONS =          "\t\t\t3. Orders' operations.";
    public static final String MENU_ITEM_4_ANALYTICS_REPORTS =         "\t\t\t4. Analytics reports.";
    public static final String MENU_ITEM_5_INPUT_OUTPUT =              "\t\t\t5. Input/Output Operations.";

    public static final String MENU_ITEM_0_QUIT_TO_MAIN =              "\t\t\t\t0. Quit to Main menu.";

    public static final String MENU_HOTEL_FACILITY =                   "\t\t\t===== Menu Hotel Facilities =====";
    public static final String MENU_ITEM_1_ROOM_OPERATION =            "\t\t\t\t\t1. Room operations.";
    public static final String MENU_ITEM_2_TABLE_OPERATION =           "\t\t\t\t\t2. Table operations. (DO NOT USE)";
    public static final String MENU_ITEM_3_TRANSPORT_OPERATION =       "\t\t\t\t3. Transport operations. (DO NOT USE)";

    public static final String MENU_ROOM =                             "\t\t\t===== Menu Rooms =====";
    public static final String MENU_ITEM_1_READ_ALL_ROOMS =            "\t\t\t1. Read all Rooms.";
    public static final String MENU_ITEM_2_READ_ROOM =                 "\t\t\t2. Read Room.";
    public static final String MENU_ITEM_3_CREATE_ROOM =               "\t\t\t\t3. Create new Room.";
    public static final String MENU_ITEM_4_UPDATE_ROOM =               "\t\t\t\t4. Update Room.";
    public static final String MENU_ITEM_5_UPDATE_ROOM_AVAILABLE =     "\t\t\t5. Update RoomStatus: Available.";
    public static final String MENU_ITEM_6_UPDATE_ROOM_REPAIRED =      "\t\t\t6. Update RoomStatus: Repaired.";
    public static final String MENU_ITEM_7_DELETE_ROOM =               "\t\t\t\t7. Delete Room.";

    public static final String MENU_ROOM_LEVEL =                       "\t\t--- Rooms' levels --- ";
    public static final String MENU_ROOM_1 =                           "\t\t\t1. Economy 1*";
    public static final String MENU_ROOM_2 =                           "\t\t\t2. Standard 2**";
    public static final String MENU_ROOM_3 =                           "\t\t\t\t3. Lux 3***";

    public static final String MENU_GUEST =                            "\t\t\t\t===== Menu Guests =====";
    public static final String MENU_ITEM_1_READ_ALL_GUESTS =           "\t\t\t\t1. Read all Guests.";
    public static final String MENU_ITEM_2_READ_GUEST =                "\t\t\t\t2. Read Guest.";
    public static final String MENU_ITEM_3_CREATE_GUEST =              "\t\t\t3. Create new Guest.";
    public static final String MENU_ITEM_4_UPDATE_GUEST =              "\t\t\t4. Update Guest.";
    public static final String MENU_ITEM_5_DELETE_GUEST =              "\t\t\t5. Delete Guest.";

    public static final String MENU_ORDER =                            "\t\t\t\t===== Menu Orders =====";
    public static final String MENU_ITEM_1_READ_ALL_ORDERS =           "\t\t\t\t1. Read all Order.";
    public static final String MENU_ITEM_2_READ_ORDER =                "\t\t\t\t2. Read Order.";
    public static final String MENU_ITEM_3_CREATE_ORDER =              "\t\t\t3. Create new Order.";
    public static final String MENU_ITEM_4_UPDATE_ORDER =              "\t\t\t4. Update Order.";
    public static final String MENU_ITEM_5_DELETE_ORDER =              "\t\t\t5. Delete Order.";

    public static final String MENU_INPUT_OUTPUT =                         "\t\t\t===== Data's Import-Export =====";
    public static final String MENU_ITEM_1_IMPORT_ALL_DATA =               "\t\t\t1. Import (load) all application's Entities from file (use after START application).";
    public static final String MENU_ITEM_2_EXPORT_ALL_DATA =               "\t\t\t2. Export (save) all application's Entities to file (use before EXIT application).";
    public static final String MENU_ITEM_3_IMPORT_ROOM_DATA =              "\t\t\t3. Import (load) Rooms' information from file (works only for Hotel Facility - ROOM).";
    public static final String MENU_ITEM_4_EXPORT_ROOM_DATA =              "\t\t\t4. Export (save) Rooms' information from file (works only for Hotel Facility - ROOM).";
    public static final String MENU_ITEM_5_IMPORT_GUEST_DATA =             "\t\t\t5. Import (load) Guests' information from file.";
    public static final String MENU_ITEM_6_EXPORT_GUEST_DATA =             "\t\t\t6. Export (save) Guests' information to file.";
    public static final String MENU_ITEM_7_IMPORT_SERVICE_AND_ORDER_DATA = "\t\t7. Import (load) Orders' and Services' information from file.";
    public static final String MENU_ITEM_8_EXPORT_SERVICE_AND_ORDER_DATA = "\t\t8. Export (save) Orders' and Services' (RoomReservation only) information to file.";

    public static final String MENU_HOTEL_SERVICE =                        "\t\t===== Hotel Services =====";
    public static final String MENU_ITEM_0_QUIT_TO_ORDER_MENU =            "\t\t\t0. Save List and Quit to Order menu.";
    public static final String MENU_ITEM_1_ROOM_RESERVATION =              "\t\t\t1. Room Reservation.";
    public static final String MENU_ITEM_2_RESTAURANT_RESERVATION =        "\t\t\t2. Restaurant Reservation. (DO NOT USE)";
    public static final String MENU_ITEM_3_TRANSFER_RESERVATION =          "\t\t\t3. Transfer Reservation. (DO NOT USE)";
    public static final String MENU_HOTEL_SERVICE_SELECT =                 "\t\t\tSelect type of Hotel's Service you want to update --> ";

    public static final String MENU_ANALYTICS_REPORTS =                        "\t\t\t\t===== Menu Analytics Reports =====";
    public static final String MENU_ITEM_1_SORT_ROOMS_BY_PRICE =               "\t\t\t\t\t1. List of rooms sort by price.";
    public static final String MENU_ITEM_2_SORT_ROOMS_BY_CAPACITY =            "\t\t\t\t2. List of rooms by capacity.";
    public static final String MENU_ITEM_3_SORT_ROOMS_BY_LEVEL =               "\t\t\t\t\t3. List of rooms by number of stars.";
    public static final String MENU_ITEM_4_SORT_AVAILABLE_ROOMS_BY_PRICE =     "\t\t\t4. List of available rooms sort " +
            "by price.";
    public static final String MENU_ITEM_5_SORT_AVAILABLE_ROOMS_BY_CAPACITY =  "\t\t5. List of available rooms sort " +
            "by capacity.";
    public static final String MENU_ITEM_6_SORT_AVAILABLE_ROOMS_BY_LEVEL =     "\t\t\t6. List of available rooms sort " +
            "by number of stars.";
    public static final String MENU_ITEM_7_GUESTS_SORTED_BY_NAME_AND_ROOMS =   "\t\t\t7. List of guests and their rooms " +
            "sort alphabetically.";
    public static final String MENU_ITEM_8_GUESTS_AND_ROOMS_SORTED_BY_CHECK_OUT =       "\t\t8. List of guests" +
            " and their rooms sort by check-out date.";
    public static final String MENU_ITEM_9_COUNT_AVAILABLE_ROOMS =             "\t\t\t\t9. Total number of available rooms.";
    public static final String MENU_ITEM_10_COUNT_GUESTS =                     "\t\t\t\t10. Total number of guests.";
    public static final String MENU_ITEM_11_COUNT_GUESTS_ON_DATE =             "\t\t\t\t\t11. Total number of guests on date.";
    public static final String MENU_ITEM_12_AVAILABLE_ROOMS_ON_DATE =          "\t\t\t\t12. List of available rooms" +
            " on date.";
    public static final String MENU_ITEM_13_PAYMENT_OF_GUEST =                 "\t\t\t\t\t13. Payment for the room to be paid" +
            " by the guest.";
    public static final String MENU_ITEM_14_LAST_GUEST_FOR_ROOM_AND_DATES =    "\t\t\t14. Last 3 guests of the room and" +
            " the dates of their stay.";
    public static final String MENU_ITEM_15_LIST_OF_SERVICES_SORTED_BY_PRICE = "\t\t15. List of Guest's Services" +
            " and their price sort by price.";
    public static final String MENU_ITEM_16_LIST_OF_SERVICES_SORTED_BY_DATE =  "\t\t16. List of Guest's Services" +
            " and their price sort by date.";
    public static final String MENU_ITEM_17_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_CATEGORY =  "17. Prices of services" +
            " and rooms sort by category.";
    public static final String MENU_ITEM_18_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_PRICE =     "\t18. Prices of services" +
            " and rooms sort by price.";
    public static final String MENU_ITEM_19_ROOM_INFORMATION =                 "\t\t\t\t\t19. Read separate room" +
            " (WHAT DOES IT MEAN???).";

}
