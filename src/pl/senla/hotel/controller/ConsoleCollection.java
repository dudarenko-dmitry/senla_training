package pl.senla.hotel.controller;

import pl.senla.hotel.entity.*;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.HotelConstant.*;

public class ConsoleCollection implements Console{

    private final ControllerRoom roomController = new ControllerRoomCollection();
    private final ControllerFacility facilityController = new ControllerFacilityCollection();
    private final ControllerRoomReservation roomReservationController = new ControllerRoomReservationCollection();
    private final ControllerGuest guestController = new ControllerGuestCollection();
    private final ControllerOrder orderController = new ControllerOrderCollection();

    @Override
    public void start(){

        System.out.println("\n----- Room and FreeRoom -----");
        System.out.println("==============================");
        System.out.println("CREATE and READ ROOMS");
        Room room0 = new Room(0, CategoryFacility.ROOM.getTypeName(), "11",100,1, RoomLevel.STANDART.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom0 = new FreeRoom(0, room0, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom in CONSTRUCTOR
        facilityController.create(room0);
        roomReservationController.createFreeRoom(freeRoom0);
        Room room1 = new Room(1,CategoryFacility.ROOM.getTypeName(), "12",120,2,RoomLevel.ECONOM.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom1 = new FreeRoom(1, room1, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room1);
        roomReservationController.createFreeRoom(freeRoom1);
        Room room2 = new Room(2,CategoryFacility.ROOM.getTypeName(), "13",150,2,RoomLevel.LUX.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom2 = new FreeRoom(2, room2, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room2);
        roomReservationController.createFreeRoom(freeRoom2);
        Room room3 = new Room(3,CategoryFacility.ROOM.getTypeName(), "21",100,1,RoomLevel.STANDART.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom3 = new FreeRoom(3, room3, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room3);
        roomReservationController.createFreeRoom(freeRoom3);
        Room room4 = new Room(4,CategoryFacility.ROOM.getTypeName(), "22",120,2,RoomLevel.ECONOM.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom4 = new FreeRoom(4, room4, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room4);
        roomReservationController.createFreeRoom(freeRoom4);
        Room room5 = new Room(5,CategoryFacility.ROOM.getTypeName(), "23",150,2,RoomLevel.LUX.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom5 = new FreeRoom(5, room5, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room5);
        roomReservationController.createFreeRoom(freeRoom5);
        Room room6 = new Room(6,CategoryFacility.ROOM.getTypeName(), "31",110,1,RoomLevel.STANDART.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom6 = new FreeRoom(6, room6, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room6);
        roomReservationController.createFreeRoom(freeRoom6);
        Room room7 = new Room(7,CategoryFacility.ROOM.getTypeName(), "32",140,2,RoomLevel.ECONOM.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom7 = new FreeRoom(7, room7, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room7);
        roomReservationController.createFreeRoom(freeRoom7);
        Room room8 = new Room(8,CategoryFacility.ROOM.getTypeName(), "33",160,2,RoomLevel.LUX.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom8 = new FreeRoom(8, room8, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room8);
        roomReservationController.createFreeRoom(freeRoom8);
        Room room9 = new Room(9,CategoryFacility.ROOM.getTypeName(), "41",400,4,RoomLevel.LUX.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom9 = new FreeRoom(9, room9, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room9);
        roomReservationController.createFreeRoom(freeRoom9);
        Room room10 = new Room(10,CategoryFacility.ROOM.getTypeName(), "42",400,4,RoomLevel.LUX.getLevel(), RoomStatus.AVAILABLE.getStatus());
        FreeRoom freeRoom10 = new FreeRoom(10, room10, START_DATE_YEAR, END_DATE_YEAR); // create automatic changing IDfreeRoom
        facilityController.create(room10);
        roomReservationController.createFreeRoom(freeRoom10);

        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room0));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room1));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room2));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room3));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room4));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room5));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room6));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room7));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room8));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room9));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room10));
        System.out.println(roomController.read(0));
        System.out.println(roomController.read(1));
        System.out.println(roomController.read(2));
        System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());
        System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + roomReservationController.readAllFreeRooms());

        System.out.println("\n=========================");
        System.out.println("UPDATE ROOM");
        room0.setPrice(200); // create later methods for changing of different attributes
        System.out.println(CONSOLE_CHANGE_ROOM + roomController.update(room0));
        System.out.println(roomController.read(0));
        System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());

        // add automatic deleting of HotelService and Order in case of deleting of Room
        System.out.println("\n=======================");
        System.out.println("DELETE ROOM");
        System.out.println(CONSOLE_DELETE_ROOM + roomController.delete(10));
        System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());

        System.out.println("\n----- GUEST -----");
        System.out.println("=============================");
        System.out.println("CREATE and READ GUEST");
        Guest guest0 = new Guest(0, "Tom", 351434000);
        Guest guest1 = new Guest(1, "John", 380452004);
        Guest guest2 = new Guest(2, "Sam", 905350895);
        Guest guest3 = new Guest(3, "Adam", 13564899);
        Guest guest4 = new Guest(4, "Helen", 905350235);
        Guest guest5 = new Guest(5, "Buddy", 905350124);
        Guest guest6 = new Guest(6, "Steve", 2834595);
        Guest guest7 = new Guest(7, "Jim", 624339229);
        Guest guest8 = new Guest(8, "Olga", 33343466);
        Guest guest9 = new Guest(9, "Violet", 22222222);
        Guest guest10 = new Guest(10, "Eugene", 3333333);
        Guest guest11 = new Guest(11, "Sally", 44444444);

        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest0));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest1));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest2));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest3));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest4));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest5));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest6));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest7));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest8));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest9));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest10));
        System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guest11));
        System.out.println(guestController.read(0));
        System.out.println(guestController.read(1));
        System.out.println(guestController.read(2));
        System.out.println(CONSOLE_READ_ALL_GUESTS + guestController.readAll());

        System.out.println("\n============================");
        System.out.println("UPDATE GUEST");
        guest0.setPhoneNumber(378340012); //update Client
        System.out.println(CONSOLE_CHANGE_GUEST + guestController.update(guest0));
        System.out.println(guestController.read(0));
        System.out.println(CONSOLE_READ_ALL_GUESTS + guestController.readAll());

        System.out.println("\n=============================");
        System.out.println("DELETE GUEST");
        System.out.println(CONSOLE_DELETE_GUEST + guestController.delete(11));
        System.out.println(CONSOLE_READ_ALL_GUESTS + guestController.readAll());

        System.out.println("\n----- RoomReservation -----");
        System.out.println("=============================");
        System.out.println("CREATE and READ RESERVATION");
        LocalDate startDay0 = LocalDate.of(2023,7,1);
        LocalDate startDay1 = LocalDate.of(2023,7,2);
        LocalDate startDay2 = LocalDate.of(2023,7,15);
        LocalDate startDay3 = LocalDate.of(2023,7,3);
        LocalDate startDay4 = LocalDate.of(2023,7,5);
        LocalDate startDay5 = LocalDate.of(2023,7,8);
        LocalDate startDay6 = LocalDate.of(2023,7,12);
        LocalDate startDay7 = LocalDate.of(2023,7,3);
        LocalDate startDay8 = LocalDate.of(2023,7,3);
        LocalDate startDay9 = LocalDate.of(2023,7,3);
        RoomReservation roomReservation0 = new RoomReservation(0,guestController.read(0),
                roomController.read(0), startDay0, 2);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation0));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(0));

        RoomReservation roomReservation1 = new RoomReservation(1, guestController.read(1),
                roomController.read(1), startDay1,3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation1));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(1));

        RoomReservation roomReservation2 = new RoomReservation(2, guestController.read(1),
                roomController.read(2), startDay2,3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation2));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(2));

        RoomReservation roomReservation3 = new RoomReservation(3, guestController.read(1),
                roomController.read(3), startDay3, 3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation3));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(3));

        RoomReservation roomReservation4 = new RoomReservation(4, guestController.read(1),
                roomController.read(4), startDay4, 3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation4));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(4));

        RoomReservation roomReservation5 = new RoomReservation(5, guestController.read(5),
                roomController.read(5), startDay5, 3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation5));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(5));

        RoomReservation roomReservation6 = new RoomReservation(6, guestController.read(6),
                roomController.read(6), startDay6, 3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation6));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(6));

        RoomReservation roomReservation7 = new RoomReservation(7, guestController.read(7),
                roomController.read(7), startDay7, 3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation7));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(7));

        RoomReservation roomReservation8 = new RoomReservation(8, guestController.read(8),
                roomController.read(8), startDay8, 3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation8));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(8));

        RoomReservation roomReservation9 = new RoomReservation(9, guestController.read(9),
                roomController.read(9), startDay9, 3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation9));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(9));

        // !!!!! avoid creating new RoomReservation with Client=null||Room=Null !!!!!

        // create later methods for changing of different attributes
        System.out.println("\n=============================");
        System.out.println("UPDATE RESERVATION");
        roomReservation1.setNumberOfDays(5);
        roomReservation1.setCost(); // add automatic editing COST during ROOM UPDATE !!!
        // add check if room is FREE for new period during UPDATE !!!
        System.out.println(CONSOLE_CHANGE_ROOM_RESERVATION + roomReservationController.update(roomReservation1));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(1));
        System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + roomReservationController.readAll());
        System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + roomReservationController.readAllFreeRooms());

        System.out.println("\n========================");
        System.out.println("DELETE RESERVATION and MAKE ROOM FREE");
        System.out.println(CONSOLE_DELETE_ROOM_RESERVATION + roomReservationController.delete(1));
        System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + roomReservationController.readAll());
        System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + roomReservationController.readAllFreeRooms());

        System.out.println("\n----- Order -----");
        System.out.println("\n=========================");
        System.out.println("CREATE ORDERS");
        //move this action to Creating Client
        List<HotelService> services0 = new ArrayList<>();
        List<HotelService> services1 = new ArrayList<>();
        //move this action/these actions to Creating RoomReservation, Restaurant and other HotelServices.
        services0.add(roomReservation0);
        services1.add(roomReservation1);
        services1.add(roomReservation2);
        services1.add(roomReservation3);
        services1.add(roomReservation4);
        Order order0 = new Order(0, guestController.read(0),services0);
        System.out.println(CONSOLE_CREATE_ORDER + orderController.create(order0));
        System.out.println(orderController.read(0));
        Order order1 = new Order(1, guestController.read(1),services1);
        System.out.println(CONSOLE_CREATE_ORDER + orderController.create(order1));
        System.out.println(orderController.read(1));

        System.out.println(CONSOLE_READ_ALL_ORDERS + orderController.readAll());

        System.out.println("\n=========================");
        System.out.println("UPDATE ORDERS");
        // some logic

        System.out.println("\n==========================");
        System.out.println("DELETE ORDERS");
        // some logic

        System.out.println("\n------------ TASK 4.1. -----------");
        System.out.println("===========================");
        System.out.println("Sort Room By Price");
        System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_PRICE +
                roomController.readAllRoomsSortByPrice());
        System.out.println("Sort Room By Capacity");
        System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_CAPACITY +
                roomController.readAllRoomsSortByCapacity());
        System.out.println("Sort Room By Status");
        System.out.println(CONSOLE_READ_ALL_ROOMS + SORTED_BY_LEVEL +
                roomController.readAllRoomsSortByLevel());

        System.out.println("\n=========================");
        System.out.println("Sort Free Rooms By Price");
        System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_PRICE +
                roomReservationController.readAllFreeRoomsSortByPrice());
        System.out.println("Sort Free Room By Capacity");
        System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_CAPACITY +
                roomReservationController.readAllFreeRoomsSortByCapacity());
        System.out.println("Sort Free Room By Status");
        System.out.println(CONSOLE_READ_ALL_FREE_ROOMS + SORTED_BY_LEVEL +
                roomReservationController.readAllFreeRoomsSortByLevel());

        System.out.println("\n========================");
        System.out.println("Sort RoomReservations By GuestName");
        System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + SORTED_BY_GUEST_NAME +
                roomReservationController.readAllRoomReservationsSortByGuestName());
        System.out.println("Sort RoomReservations By CheckOut");
        System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + SORTED_BY_CHECK_OUT +
                roomReservationController.readAllRoomReservationsSortByGuestCheckOut());

        System.out.println("\n=======================");
        System.out.println("Count Free Room on Date");
        LocalDateTime checkedTime = LocalDateTime.of(2023,7,3, 15, 0);
        System.out.println(CONSOLE_NUMBER_OF_FREE_ROOMS + checkedTime + ": " +
                roomReservationController.countFreeRoomsOnTime(checkedTime));

        System.out.println("\n============================");
        System.out.println("Count Total number of registered Guest in DataBase");
        System.out.println(CONSOLE_NUMBER_GUEST_TOTAL + guestController.countNumberOfGuestsTotal());
        System.out.println("Count number of Guest in Hotel on Date");
        System.out.println(CONSOLE_NUMBER_GUEST_IN_HOTEL_NOW + checkedTime + ": " +
                roomReservationController.countNumberOfGuestsOnDate(checkedTime));

        System.out.println("\n===========================");
        System.out.println("List of all Free rooms at Time");
        System.out.println(CONSOLE_READ_ALL_FREE_ROOMS_TIME + roomReservationController.readAllRoomsFreeAtTime(checkedTime));

        System.out.println("\n===========================");
        System.out.println("Guest's payment for room");
        System.out.println(CONSOLE_GUEST_PAYMENT_FOR_ROOM + roomReservationController.countGuestPaymentForRoom(2));

        System.out.println("\n8 ===========================");
        System.out.println("3 last Guest and their dates of stays for room");
        System.out.println(CONSOLE_3_GUESTS_AND_DATES + roomReservationController.read3LastGuestAndDatesForRoom(5));

        System.out.println("\n9 ===========================");
        System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_GUEST + SORTED_BY_PRICE + orderController.readAllServicesSortByPrice(1));
        System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_GUEST + SORTED_BY_DATE + orderController.readAllServicesSortByDate(1));

        System.out.println("\n10 ===========================");
        //checked without creating instances Table and Transport
        System.out.println(CONSOLE_READ_ALL_FACILITIES + SORTED_BY_CATEGORY + facilityController.readPriceListForServicesSortByCategory());
        System.out.println(CONSOLE_READ_ALL_FACILITIES + SORTED_BY_PRICE + facilityController.readPriceListForServicesSortByPrice());

    }
}
