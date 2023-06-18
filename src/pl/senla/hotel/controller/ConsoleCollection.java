package pl.senla.hotel.controller;

import pl.senla.hotel.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.*;

public class ConsoleCollection implements Console{

    //Было так. Сделать после всех проверок внедрение зависимостей через конструктор
    private final Controller<Room> roomController = new RoomController();
    private final Controller<RoomReservation> roomReservationController = new RoomReservationController();
    private final Controller<Client> clientController = new ClientController();
    private final Controller<Order> orderController = new OrderController();

    @Override
    public void start(){

        System.out.println("\n----- Room -----");

        Room room0 = new Room(0,11,100,1, RoomLevel.STANDART.getLevel(), RoomStatus.FREE.getStatus());
        Room room1 = new Room(1,12,120,2,RoomLevel.ECONOM.getLevel(), RoomStatus.FREE.getStatus());
        Room room2 = new Room(2,13,130,2,RoomLevel.LUX.getLevel(), RoomStatus.FREE.getStatus());

        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room0));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room1));
        System.out.println(CONSOLE_CREATE_ROOM + roomController.create(room2));
        System.out.println(roomController.read(0));
        System.out.println(roomController.read(1));
        System.out.println(roomController.read(2));
        System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());

        room0.setRoomPrice(200); // create later methods for changing of different attributes
        System.out.println(CONSOLE_CHANGE_ROOM + roomController.update(room0));
        System.out.println(roomController.read(0));
        System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());

        System.out.println(CONSOLE_DELETE_ROOM + roomController.delete(2));
        System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());


        System.out.println("\n----- Client -----");

        Client client0 = new Client(0, "Tom", 351434000);
        Client client1 = new Client(1, "John", 380452004);
        Client client2 = new Client(2, "Sam", 905350895);

        System.out.println(CONSOLE_CREATE_CLIENT + clientController.create(client0));
        System.out.println(CONSOLE_CREATE_CLIENT + clientController.create(client1));
        System.out.println(CONSOLE_CREATE_CLIENT + clientController.create(client2));
        System.out.println(clientController.read(0));
        System.out.println(clientController.read(1));
        System.out.println(clientController.read(2));
        System.out.println(CONSOLE_READ_ALL_CLIENTS + clientController.readAll());

        client0.setPhoneNumber(378340012); //update Client
        System.out.println(CONSOLE_CHANGE_CLIENT + clientController.update(client0));
        System.out.println(clientController.read(0));
        System.out.println(CONSOLE_READ_ALL_CLIENTS + clientController.readAll());

        System.out.println(CONSOLE_DELETE_CLIENT + clientController.delete(2));
        System.out.println(CONSOLE_READ_ALL_CLIENTS + clientController.readAll());

        System.out.println("\n----- RoomReservation -----");
        System.out.println("=============================");
        System.out.println("CREATE and READ RESERVATION");
        LocalDate startDay0 = LocalDate.of(2023,7,1);
        LocalDate startDay1 = LocalDate.of(2023,7,2);
        LocalDate startDay2 = LocalDate.of(2023,7,3);
        System.out.println(clientController.read(0));
        System.out.println(roomController.read(0));
        RoomReservation roomReservation0 = new RoomReservation(0,startDay0,clientController.read(0),roomController.read(0),2);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation0));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(0));
        System.out.println(clientController.read(1));
        System.out.println(roomController.read(1));
        RoomReservation roomReservation1 = new RoomReservation(1,startDay1,clientController.read(1),roomController.read(1),3);
        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation1));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(1));

        // !!!!! avoid creating new RoomReservation with Client=null||Room=Null !!!!!
        System.out.println("\n-----------------------------------");
        System.out.println("Try to CREATE RESERVATION with NULL Client and Room");
        RoomReservation roomReservation2 = new RoomReservation(2,startDay2,clientController.read(2),roomController.read(2),5);

        System.out.println(CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation2));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(2));
        System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + roomReservationController.readAll());

        // create later methods for changing of different attributes
        System.out.println("\n=============================");
        System.out.println("UPDATE RESERVATION");
        roomReservation1.setNumberOfDays(5);
        roomReservation1.setCost(); // add automatic editing COST during ROOM UPDATE !!!
        // add check if room is FREE for new period during UPDATE !!!
        System.out.println(CONSOLE_CHANGE_ROOM_RESERVATION + roomReservationController.update(roomReservation1));
        System.out.println(CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(1));
        System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + roomReservationController.readAll());

        // Delete RoomReservation works. Take off comments after checking of Order's work
//        System.out.println("\n=============================");
//        System.out.println("DELETE RESERVATION and MAKE ROOM FREE");
//        Room roomToBeFree = roomController.read(roomReservationController.read(1).getRoom().getRoomId());
//        roomToBeFree.setRoomStatus(RoomStatus.FREE.getStatus()); // add automatic change RoomStatus after deleting of Reservation
//        System.out.println(CONSOLE_DELETE_ROOM_RESERVATION + roomReservationController.delete(1));
//        System.out.println(CONSOLE_READ_ALL_ROOM_RESERVATIONS + roomReservationController.readAll());
//        System.out.println(CONSOLE_READ_ALL_ROOMS + roomController.readAll());


        System.out.println("\n----- Order -----");
        System.out.println("\n===========================");
        System.out.println("CREATE ORDERS");
        //move this action to Creating Client
        List<HotelService> services0 = new ArrayList<>();
        List<HotelService> services1 = new ArrayList<>();
        //move this action/these actions to Creating RoomReservation, Restorant and other HotelServices.
        services0.add(roomReservation0);
        services1.add(roomReservation1);
        Order order0 = new Order(0,clientController.read(0),services0);
        System.out.println(CONSOLE_CREATE_ORDER + orderController.create(order0));
        System.out.println(orderController.read(0));
        Order order1 = new Order(1,clientController.read(1),services1);
        System.out.println(CONSOLE_CREATE_ORDER + orderController.create(order1));
        System.out.println(orderController.read(1));

        System.out.println(CONSOLE_READ_ALL_ORDERS + orderController.readAll());
    }
}
