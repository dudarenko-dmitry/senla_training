package pl.senla.hotel.ui;

public class NotUsedMenus {

    /**
     * MenuTable, MenuTransfer
     *
    private void startMenuTable() {
        while (true) {
            printMenuTable();
            int index = makeChoice();
            navigateMenuTable(index);
        }
    } //ready. do not use

    private void printMenuTable() {
        System.out.println("\n===== Menu Tables =====");
        System.out.println("1. Read all Rooms. ");
        System.out.println("2. Read Room. ");
        System.out.println("3. Create new Room. ");
        System.out.println("4. Update Room. ");
        System.out.println("5. Delete Room. ");
        System.out.println("0. Quit to Main menu. ");
    } //ready. do not use

    private void navigateMenuTable(int index) {
    } // do not use

    private void startMenuTransport() {
        while (true) {
            printMenuTransport();
            int index = makeChoice();
            navigateMenuTransport(index);
        }
    } //ready. do not use

    private void printMenuTransport() {
        System.out.println("\n===== Menu Transports =====");
        System.out.println("1. Read all Transports. ");
        System.out.println("2. Read Transport. ");
        System.out.println("3. Create new Transport. ");
        System.out.println("4. Update Transport. ");
        System.out.println("5. Delete Transport. ");
        System.out.println("0. Quit to Main menu. ");
    } //ready. do not use

    private void navigateMenuTransport(int index) {
    } // do not use

     */

    /**
     * MenuHotelServices. Application works only with RoomReservation.  Restaurant and Transfer do not use
     *
     //    private void printMenuHotelServices() { // printCreateHotelServiceList or DELETE
     //        System.out.println("\n===== Menu HotelServices =====");
     //        System.out.println("1. Read all HotelServices. "); //delete
     //        System.out.println("2. Read HotelService. "); //delete
     //        System.out.println("3. Create new HotelService. ");
     //        System.out.println("4. Update HotelService. "); //delete
     //        System.out.println("5. Delete HotelService. "); //delete
     //        System.out.println("0. Save List and Quit to Order menu. ");
     //    } //ready
     //
     //    private List<HotelService> navigateMenuHotelServices(List<HotelService> servicesGuest, Guest guest, int index){ // navigateCreateHotelServiceList
     //        Scanner sc = new Scanner(System.in);
     //        switch (index){
     //            case 1: //delete
     //                System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_GUEST + servicesGuest);
     //                break;
     //            case 2: //delete
     //                System.out.print("Input ID of Service --> ");
     //                int idService = sc.nextInt();
     //                orderController.read(idService);
     //                break;
     //            case 3:
     //                System.out.println("Add new HotelService (works only for RoomReservations!!!) to Order.");
     //                RoomReservation roomReservationNew = selectTypeHotelServices(guest); //Later change return from RoomReservation to HotelService and refactor
     //                System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservationNew));
     //                servicesGuest.add(roomReservationNew);
     //                break;
     //            case 4: //delete
     //                System.out.println("Update HotelService (works only for RoomReservations!!!) to Order.");
     //
     //                break;
     //            case 0:
     //                return servicesGuest;
     //            default:
     //                System.out.println(ERROR_INPUT_NAVIGATE);
     //                navigateMenuHotelServices(servicesGuest, guest, index);
     //        }
     //        return servicesGuest;
     //    }
     //
     //    private RoomReservation selectTypeHotelServices(Guest guest){
     //        printSelectHotelServices();
     //        int index = makeChoice();
     //        return navigateSelectTypeHotelServices(guest, index);
     //    } //ready //Later change return from RoomReservation to HotelService and refactor


     *
     *
     * private void printMenuRoomReservation() {
     * System.out.println("\n===== Menu RoomReservations =====");
     * System.out.println("1. Read all RoomReservations. ");
     * System.out.println("2. Read RoomReservation. ");
     * System.out.println("3. Create new RoomReservation. ");
     * System.out.println("4. Update RoomReservation. ");
     * System.out.println("5. Delete RoomReservation. ");
     * System.out.println("0. Quit to Main menu. ");
     * } //ready //create EXECUTOR
     * <p>
     * private void printMenuRestaurantReservation() {
     * System.out.println("\n===== Menu RestaurantReservations =====");
     * System.out.println("1. Read all RestaurantReservations. ");
     * System.out.println("2. Read RestaurantReservation. ");
     * System.out.println("3. Create new RestaurantReservation. ");
     * System.out.println("4. Update RestaurantReservation. ");
     * System.out.println("5. Delete RestaurantReservation. ");
     * System.out.println("0. Quit to Main menu. ");
     * } //ready //create EXECUTOR
     * <p>
     * private void printMenuTransferReservation() {
     * System.out.println("\n===== Menu TransferReservations =====");
     * System.out.println("1. Read all TransferReservations. ");
     * System.out.println("2. Read TransferReservation. ");
     * System.out.println("3. Create new TransferReservation. ");
     * System.out.println("4. Update TransferReservation. ");
     * System.out.println("5. Delete TransferReservation. ");
     * System.out.println("0. Quit to Main menu. ");
     * } //ready //create EXECUTOR
     */

}

