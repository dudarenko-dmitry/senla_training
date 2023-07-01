package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.HotelConstant.*;

public class ConsoleUI implements Console {

    private final ControllerRoom roomController = new ControllerRoomCollection();
    private final ControllerFacility facilityController = new ControllerFacilityCollection();
    private final ControllerRoomReservation roomReservationController = new ControllerRoomReservationCollection();
    private final ControllerGuest guestController = new ControllerGuestCollection();
    private final ControllerOrder orderController = new ControllerOrderCollection();

    @Override
    public void startMainMenu() {
        while (true) {
            printMainMenu();
            int index = makeChoice();
            navigateMainMenu(index);
        }
    } // ready

    private void printMainMenu() {
        System.out.println("<<<<< Welcome to Hotel >>>>>");
        System.out.println("===== Main menu =====");
        System.out.println("1. Hotel facilities operations. ");
        System.out.println("2. Guests operations. ");
        System.out.println("3. Orders' operations. ");
        System.out.println("4. Analytics reports. ");
        System.out.println("0. Quit from program. ");
    } //ready

    private void navigateMainMenu(int index) {
        switch (index) {
            case 1 -> startMenuHotelFacilities();
            case 2 -> startMenuGuest();
            case 3 -> startMenuOrder();
            case 4 -> startMenuAnalytics();
            case 0 -> {
                System.out.println("Good-bye.");
                System.exit(0);
            }
            default -> System.out.println(ERROR_INPUT_NAVIGATE);
        }
    } //ready

    private void startMenuHotelFacilities() {
        while (true) {
            printSelectHotelFacilities();
            int index = makeChoice();
            navigateMenuHotelFacilities(index);
        }
    } //ready

    private void printSelectHotelFacilities() {
        System.out.println("\n===== Menu Hotel Facilities =====");
        System.out.println("1. Room operations. ");
        System.out.println("2. Table operations. ");
        System.out.println("3. Transport operations. ");
        System.out.println("0. Quit to Main menu. ");
    } //ready

    private void navigateMenuHotelFacilities(int index) {
        switch (index) {
            case 1 -> startMenuRoom();
            case 2 -> startMenuTable();
            case 3 -> startMenuTransport();
            case 0 -> startMainMenu();
            default -> System.out.println(ERROR_INPUT_NAVIGATE);
        }
    } //ready

    private void startMenuGuest() {
        while (true) {
            printMenuGuest();
            int index = makeChoice();
            navigateMenuGuest(index);
        }
    } //ready

    private void printMenuGuest() {
        System.out.println("\n===== Menu Guests =====");
        System.out.println("1. Read all Guests. ");
        System.out.println("2. Read Guest. ");
        System.out.println("3. Create new Guest. ");
        System.out.println("4. Update Guest. ");
        System.out.println("5. Delete Guest. ");
        System.out.println("0. Quit to Main menu. ");
    } //ready

    private void navigateMenuGuest(int index) {
        Scanner sc = new Scanner(System.in);
        switch (index) {
            case 1 -> {
                System.out.println(CONSOLE_READ_ALL_GUESTS);
                guestController.readAll();
            }
            case 2 -> {
                System.out.print("Input ID Guest -->");
                int id = sc.nextInt();
                System.out.println(CONSOLE_READ_GUEST + guestController.read(id));
            }
            case 3 -> {
                System.out.println("Input new Guest's data: ");
                System.out.print("Guest's name --> ");
                String name = sc.next();
                System.out.print("Guest's phone number --> ");
                int phoneNumber = sc.nextInt();
                Guest guestNew = new Guest(name, phoneNumber);
                System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guestNew));
            }
            case 4 -> {
                System.out.print("Input ID Guest to Update -->");
                int idGuestUpdate = sc.nextInt();
                System.out.print("Input new phoneNumber --> ");
                int newPhoneNumber = sc.nextInt();
                Guest guestUpdated = guestController.read(idGuestUpdate);
                guestUpdated.setPhoneNumber(newPhoneNumber);
                System.out.println(CONSOLE_CHANGE_GUEST + guestController.update(guestUpdated));
            }
            case 5 -> {
                System.out.print("Input ID Guest to Delete -->");
                int idGuestDelete = sc.nextInt();
                System.out.println(CONSOLE_DELETE_GUEST + guestController.delete(idGuestDelete));
            }
            case 0 -> startMainMenu();
            default -> {
                System.out.println(ERROR_INPUT_NAVIGATE);
                navigateMenuGuest(makeChoice());
            }
        }
    } // ready

    private void startMenuOrder() {
        while (true) {
            printMenuOrders();
            int index = makeChoice();
            navigateMenuOrders(index);
        }
    }

    private void printMenuOrders() {
        System.out.println("\n===== Menu Orders =====");
        System.out.println("1. Read all Order. ");
        System.out.println("2. Read Order. ");
        System.out.println("3. Create new Order. ");
        System.out.println("4. Update Order. ");
        System.out.println("5. Delete Order. ");
        System.out.println("0. Quit to Main menu. ");
    } //ready

    private void navigateMenuOrders(int index) {
        Scanner sc = new Scanner(System.in);
        switch (index) {
            case 1 -> System.out.println(CONSOLE_READ_ALL_ORDERS + orderController.readAll());
            case 2 -> {
                System.out.print("Input Order's ID -->");
                int id = sc.nextInt();
                System.out.println(CONSOLE_READ_ORDER + orderController.read(id));
            }
            case 3 -> {
                System.out.print("Input Guest's ID --> ");
                int guestId = sc.nextInt();
                Guest guest = guestController.read(guestId);
                List<HotelService> hotelServices = createHotelServiceList(guest);
                Order order = new Order(guest, hotelServices);
                System.out.println(CONSOLE_CREATE_ORDER + orderController.create(order));
            }
            case 4 -> {
                System.out.print("Input Order's ID to Update -->");
                int idUpdate = sc.nextInt();
                Order orderUpdated = orderController.read(idUpdate);
                List<HotelService> services = orderUpdated.getServices();
                services = updateHotelServiceList(services);
                orderUpdated.setServices(services);
                System.out.println(CONSOLE_CREATE_ORDER + orderController.update(orderUpdated));
            }
            case 5 -> {
                System.out.print("Input ID Order to Delete -->");
                int idOrderDelete = sc.nextInt();
                System.out.println(CONSOLE_DELETE_ORDER + orderController.delete(idOrderDelete));
            }
            case 0 -> startMainMenu();
            default -> {
                System.out.println(ERROR_INPUT_NAVIGATE);
                navigateMenuOrders(makeChoice());
            }
        }
    } // in progress

    private List<HotelService> updateHotelServiceList(List<HotelService> services) {
        Scanner sc = new Scanner(System.in);
        System.out.println(CONSOLE_READ_ALL_SERVICES + services);
        System.out.print("Input Service's ID to Update -->");
        int idService = sc.nextInt();
        printSelectCreatedHotelServices();
        System.out.print("Select Type of updating Service\n works only for (1) RoomReservation --> ");
        int typeOfServiceInt = sc.nextInt();
        return navigateUpdateHotelServiceList(services, typeOfServiceInt, idService);
    }

    private List<HotelService> navigateUpdateHotelServiceList(List<HotelService> services, int typeOfServiceInt, int idService) {
        Scanner sc = new Scanner(System.in);
        switch (typeOfServiceInt){
            case 1:
                System.out.println("Update RoomReservation: ");
                System.out.println("Input new Date. ");
                LocalDate startDate = inputDate();
                System.out.print("Input number of days to reserve --> ");
                int numberOfDays = sc.nextInt();
                RoomReservation roomReservation = roomReservationController.read(idService);
                roomReservation.setCheckInTime(LocalDateTime.of(startDate, HOTEL_CHECK_IN_TIME));
                roomReservation.setNumberOfDays(numberOfDays);
                roomReservationController.update(roomReservation);
                break;
            case 2:
                // do not use
                break;
            case 3:
                // do not use 2
                break;
            case 0:
                return services;
        }
        return services;
    }

    private List<HotelService> createHotelServiceList(Guest guest) { //createHotelServiceList
        List<HotelService> guestServices = new ArrayList<>();
        int index;
        do {
            printSelectCreatedHotelServices();
            index = makeChoice();
            guestServices.add(navigateCreateHotelServiceList(guest, index));
        } while (index != 0);
        return guestServices; //return RoomReservation
    }

    private void printSelectCreatedHotelServices() {
        System.out.println("\n===== Hotel Service =====");
        System.out.println("1. Room Reservation. ");
        System.out.println("2. Restaurant Reservation. ");
        System.out.println("3. Transfer Reservation. ");
        System.out.println("0. Save List and Quit to Order menu. ");
    } //ready

    //Later change return from RoomReservation to HotelService and refactor
    private RoomReservation navigateCreateHotelServiceList(Guest guest, int index) { //use only (1) RoomReservation
        Scanner sc = new Scanner(System.in);
        switch (index) {
            case 1:
                System.out.print("Input Id Room --> ");
                int idRoom = sc.nextInt();
                Room room = roomController.read(idRoom);
                LocalDate startDate = inputDate();
                System.out.print("Input number of days to reserve --> ");
                int numberOfDays = sc.nextInt();
                RoomReservation roomReservationNew = new RoomReservation(guest, room, startDate, numberOfDays);
                System.out.println(CONSOLE_CREATE_ROOM_RESERVATION +
                        roomReservationController.create(roomReservationNew));
                return roomReservationNew;
            case 2: // do not use
                System.out.println("Do not use this type of Service: Restaurant. ");
                LocalDateTime startDateTime = inputDateTime();
                //logic
                //return new Restaurant(...));
                break;
            case 3: // do not use
                System.out.println("Do not use this type of Service: Transfer");
                startDateTime = inputDateTime();
                //logic
                //return new Transfer(...);
                break;
            default:
                System.out.println(ERROR_INPUT_NAVIGATE);
                navigateCreateHotelServiceList(guest, index);
        }
        return null; // return HotelServices
    } //ready

    private void startMenuAnalytics() {
        while (true) {
            printMenuAnalytics();
            int index = makeChoice();
            navigateMenuAnalytics(index);
        }
    } //ready

    private void printMenuAnalytics() {
        System.out.println("\n===== Menu Analytics Reports =====");
        System.out.println("1. . ");
        System.out.println("2. . ");
        System.out.println("3. . ");
        System.out.println("4. . ");
        System.out.println("5. . ");
        System.out.println("0. Quit to Main menu. ");
    } //TODO

    private void navigateMenuAnalytics(int index) {
    } //TODO

    private void startMenuRoom() {
        while (true) {
            printMenuRoom();
            int index = makeChoice();
            navigateMenuRoom(index);
        }
    }

    private void printMenuRoom() {
        System.out.println("\n===== Menu Rooms =====");
        System.out.println("1. Read all Rooms. ");
        System.out.println("2. Read Room. ");
        System.out.println("3. Create new Room. ");
        System.out.println("4. Update Room. ");
        System.out.println("5. Delete Room. ");
        System.out.println("0. Quit to Main menu. ");
    } //ready

    private void navigateMenuRoom(int index) {
        Scanner sc = new Scanner(System.in);
        switch (index) {
            case 1 -> System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());
            case 2 -> {
                System.out.print("Input ID Room -->");
                int id = sc.nextInt();
                System.out.println(CONSOLE_READ_ROOM + roomController.read(id));
            }
            case 3 -> {
                System.out.println("Input new Room's data: ");
                System.out.print("Room number/name --> ");
                String roomNumber = sc.next();
                System.out.print("Price of Room --> ");
                int price = sc.nextInt();
                System.out.print("Capacity of Room --> ");
                int capacity = sc.nextInt();
                String roomLevel = selectRoomLevel();
                Room room = new Room(CategoryFacility.ROOM.getTypeName(), roomNumber, price, capacity,
                        roomLevel, RoomStatus.AVAILABLE.getStatus());
                System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room));
                FreeRoom freeRoom1 = new FreeRoom(room, START_DATE_YEAR, END_DATE_YEAR);
                facilityController.create(room); // CHECK (need for creating price-list)
                roomReservationController.createFreeRoom(freeRoom1);
            }
            case 4 -> {
                System.out.print("Input ID Room to Update -->");
                int idRoomUpdate = sc.nextInt();
                System.out.print("Input new price --> ");
                int newPrice = sc.nextInt();
                Room roomUpdated = roomController.read(idRoomUpdate);
                roomUpdated.setPrice(newPrice);
                facilityController.update(roomUpdated);
                System.out.println(CONSOLE_CHANGE_ROOM + roomController.update(roomUpdated));
            }
            case 5 -> {
                System.out.print("Input ID Room to Delete -->");
                int idRoomDelete = sc.nextInt();
                System.out.println(CONSOLE_DELETE_ROOM + roomController.delete(idRoomDelete));
            }
            case 0 -> startMainMenu();
            default -> {
                System.out.println(ERROR_INPUT_NAVIGATE);
                navigateMenuRoom(makeChoice());
            }
        }
    } //ready

    private String selectRoomLevel() {
        printRoomLevel();
        System.out.print("Number of star --> ");
        return navigateRoomLevel();
    } //ready

    private void printRoomLevel() {
        System.out.println("\n Rooms' levels: ");
        System.out.println("1. Econom 1*");
        System.out.println("2. Standart 2**");
        System.out.println("3. Lux 3***");
    } //ready

    private String navigateRoomLevel() {
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        switch (level) {
            case 1:
                return RoomLevel.ECONOM.getLevel();
            case 2:
                return RoomLevel.STANDART.getLevel();
            case 3:
                return RoomLevel.LUX.getLevel();
            default:
                System.out.println(ERROR_INPUT_NAVIGATE);
                startMainMenu();
                return null;
        }
    } // ready

    private void startMenuTable() {
        while (true) {
            printMenuTable();
            int index = makeChoice();
            navigateMenuTable(index);
        }
    } //ready

    private void printMenuTable() {
        System.out.println("\n===== Menu Tables =====");
        System.out.println("1. Read all Rooms. ");
        System.out.println("2. Read Room. ");
        System.out.println("3. Create new Room. ");
        System.out.println("4. Update Room. ");
        System.out.println("5. Delete Room. ");
        System.out.println("0. Quit to Main menu. ");
    } //ready

    private void navigateMenuTable(int index) {
        // TODO document why this method is empty
    } // do not use

    private void startMenuTransport() {
        while (true) {
            printMenuTransport();
            int index = makeChoice();
            navigateMenuTransport(index);
        }
    } //ready

    private void printMenuTransport() {
        System.out.println("\n===== Menu Transports =====");
        System.out.println("1. Read all Transports. ");
        System.out.println("2. Read Transport. ");
        System.out.println("3. Create new Transport. ");
        System.out.println("4. Update Transport. ");
        System.out.println("5. Delete Transport. ");
        System.out.println("0. Quit to Main menu. ");
    } //ready

    private void navigateMenuTransport(int index) {
        // TODO document why this method is empty
    } // do not use

    private int makeChoice() {
        System.out.print("Input your choice --> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    } // ready

    private LocalDate inputDate() {
        System.out.println("Select start date of Reservation. ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input year --> ");
        int year = sc.nextInt();
        System.out.print("Input month --> ");
        int month = sc.nextInt();
        System.out.print("Input day --> ");
        int day = sc.nextInt();
        return LocalDate.of(year, month, day);
    } //ready

    private LocalDateTime inputDateTime() {
        System.out.println("Select start Time of Reservation. ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input year --> ");
        int year = sc.nextInt();
        System.out.print("Input month --> ");
        int month = sc.nextInt();
        System.out.print("Input day --> ");
        int day = sc.nextInt();
        System.out.print("Input hour --> ");
        int hour = sc.nextInt();
        System.out.print("Input minute --> ");
        int minute = sc.nextInt();
        return LocalDateTime.of(year, month, day, hour, minute);
    } //ready

    /**
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
     */

    /**
     * System.out.println("\n------------ TASK 4.1. -----------");
     * System.out.println("===========================");
     * System.out.println("Sort Room By Price");
     * System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_PRICE +
     * roomController.readAllRoomsSortByPrice());
     * System.out.println("Sort Room By Capacity");
     * System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_CAPACITY +
     * roomController.readAllRoomsSortByCapacity());
     * System.out.println("Sort Room By Status");
     * System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_LEVEL +
     * roomController.readAllRoomsSortByLevel());
     * <p>
     * System.out.println("\n=========================");
     * System.out.println("Sort Free Rooms By Price");
     * System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_PRICE +
     * roomReservationController.readAllFreeRoomsSortByPrice());
     * System.out.println("Sort Free Room By Capacity");
     * System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_CAPACITY +
     * roomReservationController.readAllFreeRoomsSortByCapacity());
     * System.out.println("Sort Free Room By Status");
     * System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_LEVEL +
     * roomReservationController.readAllFreeRoomsSortByLevel());
     * <p>
     * System.out.println("\n========================");
     * System.out.println("Sort RoomReservations By GuestName");
     * System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + SORTED_BY_GUEST_NAME +
     * roomReservationController.readAllRoomReservationsSortByGuestName());
     * System.out.println("Sort RoomReservations By CheckOut");
     * System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + SORTED_BY_CHECK_OUT +
     * roomReservationController.readAllRoomReservationsSortByGuestCheckOut());
     * <p>
     * System.out.println("\n=======================");
     * System.out.println("Count Free Room on Date");
     * LocalDateTime checkedTime = LocalDateTime.of(2023,7,3, 15, 0);
     * System.out.println(CONSOLE_NUMBER_OF_FREE_ROOMS + checkedTime + ": " +
     * roomReservationController.countFreeRoomsOnTime(checkedTime));
     * <p>
     * System.out.println("\n============================");
     * System.out.println("Count Total number of registered Guest in DataBase");
     * System.out.println(CONSOLE_NUMBER_GUEST_TOTAL + guestController.countNumberOfGuestsTotal());
     * System.out.println("Count number of Guest in Hotel on Date");
     * System.out.println(CONSOLE_NUMBER_GUEST_IN_HOTEL_NOW + checkedTime + ": " +
     * roomReservationController.countNumberOfGuestsOnDate(checkedTime));
     * <p>
     * System.out.println("\n===========================");
     * System.out.println("List of all Free rooms at Time");
     * System.out.println(CONSOLE_READ_ALL_FREE_ROOMS_TIME + roomReservationController.readAllRoomsFreeAtTime(checkedTime));
     * <p>
     * System.out.println("\n===========================");
     * System.out.println("Guest's payment for room");
     * System.out.println(CONSOLE_GUEST_PAYMENT_FOR_ROOM + roomReservationController.countGuestPaymentForRoom(guestController.read(5).getIdGuest()));
     * <p>
     * System.out.println("\n8 ===========================");
     * System.out.println("3 last Guest and their dates of stays for room");
     * System.out.println(CONSOLE_3_GUESTS_AND_DATES + roomReservationController.read3LastGuestAndDatesForRoom(roomController.read(2).getIdFacility()));
     * <p>
     * System.out.println("\n9 ===========================");
     * System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_GUEST + SORTED_BY_PRICE + orderController.readAllServicesSortByPrice(1));
     * System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_GUEST + SORTED_BY_DATE + orderController.readAllServicesSortByDate(1));
     * <p>
     * System.out.println("\n10 ===========================");
     * //checked without creating instances Table and Transport
     * System.out.println(CONSOLE_READ_ALL_FACILITIES + SORTED_BY_CATEGORY + facilityController.readPriceListForServicesSortByCategory());
     * System.out.println(CONSOLE_READ_ALL_FACILITIES + SORTED_BY_PRICE + facilityController.readPriceListForServicesSortByPrice());
     */

    /**
     * private void printMenuRoomReservation() {
     * System.out.println("\n===== Menu RoomReservations =====");
     * System.out.println("1. Read all RoomReservations. ");
     * System.out.println("2. Read RoomReservation. ");
     * System.out.println("3. Create new RoomReservation. ");
     * System.out.println("4. Update RoomReservation. ");
     * System.out.println("5. Delete RoomReservation. ");
     * System.out.println("0. Quit to Main menu. ");
     * } //ready //create NAVIGATION
     * <p>
     * private void printMenuRestaurantReservation() {
     * System.out.println("\n===== Menu RestaurantReservations =====");
     * System.out.println("1. Read all RestaurantReservations. ");
     * System.out.println("2. Read RestaurantReservation. ");
     * System.out.println("3. Create new RestaurantReservation. ");
     * System.out.println("4. Update RestaurantReservation. ");
     * System.out.println("5. Delete RestaurantReservation. ");
     * System.out.println("0. Quit to Main menu. ");
     * } //ready //create NAVIGATION
     * <p>
     * private void printMenuTransferReservation() {
     * System.out.println("\n===== Menu TransferReservations =====");
     * System.out.println("1. Read all TransferReservations. ");
     * System.out.println("2. Read TransferReservation. ");
     * System.out.println("3. Create new TransferReservation. ");
     * System.out.println("4. Update TransferReservation. ");
     * System.out.println("5. Delete TransferReservation. ");
     * System.out.println("0. Quit to Main menu. ");
     * } //ready //create NAVIGATION
     */

}

