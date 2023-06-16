package pl.senla.hotel.controller;

import pl.senla.hotel.constant.ConsoleConstant;
import pl.senla.hotel.entity.*;

import java.time.LocalDate;

public class ConsoleCollection implements Console{

    private final Controller<Room> roomController = new RoomController();
    private final Controller<RoomReservation> roomReservationController = new RoomReservationController();
    private final Controller<Client> clientController = new ClientController();

    @Override
    public void start(){

        System.out.println("\n----- Room -----");
        Room room0 = new Room(0,11,100,1, RoomLevel.STANDART.getLevel(), RoomStatus.FREE.getStatus());
        Room room1 = new Room(1,12,120,2,RoomLevel.ECONOM.getLevel(), RoomStatus.FREE.getStatus());
        Room room2 = new Room(2,13,130,2,RoomLevel.LUX.getLevel(), RoomStatus.FREE.getStatus());

        System.out.println(ConsoleConstant.CONSOLE_CREATE_ROOM + roomController.create(room0));
        System.out.println(ConsoleConstant.CONSOLE_CREATE_ROOM + roomController.create(room1));
        System.out.println(ConsoleConstant.CONSOLE_CREATE_ROOM + roomController.create(room2));
        System.out.println(roomController.read(0));
        System.out.println(roomController.read(1));
        System.out.println(roomController.read(2));
        System.out.println(ConsoleConstant.CONSOLE_READ_ALL_ROOMS + roomController.readAll());

        room0.setRoomPrice(200); // create later methods for changing of different attributes
        System.out.println(ConsoleConstant.CONSOLE_CHANGE_ROOM + roomController.update(room0));
        System.out.println(roomController.read(0));
        System.out.println(ConsoleConstant.CONSOLE_READ_ALL_ROOMS + roomController.readAll());

        System.out.println(ConsoleConstant.CONSOLE_DELETE_ROOM + roomController.delete(2));
        System.out.println(ConsoleConstant.CONSOLE_READ_ALL_ROOMS + roomController.readAll());


        System.out.println("\n----- Client -----");
        Client client0 = new Client(0, "Tom", 351434000);//change after creating Orders!!!
        Client client1 = new Client(1, "John", 380452004);//change after creating Orders!!!
        Client client2 = new Client(2, "Sam", 905350895);//change after creating Orders!!!

        System.out.println(ConsoleConstant.CONSOLE_CREATE_CLIENT + clientController.create(client0));
        System.out.println(ConsoleConstant.CONSOLE_CREATE_CLIENT + clientController.create(client1));
        System.out.println(ConsoleConstant.CONSOLE_CREATE_CLIENT + clientController.create(client2));
        System.out.println(clientController.read(0));
        System.out.println(clientController.read(1));
        System.out.println(clientController.read(2));
        System.out.println(ConsoleConstant.CONSOLE_READ_ALL_CLIENTS + clientController.readAll());

        client0.setPhoneNumber(378340012); // create later methods for changing of different attributes
        System.out.println(ConsoleConstant.CONSOLE_CHANGE_CLIENT + clientController.update(client0));
        System.out.println(clientController.read(0));
        System.out.println(ConsoleConstant.CONSOLE_READ_ALL_CLIENTS + clientController.readAll());

        System.out.println(ConsoleConstant.CONSOLE_DELETE_CLIENT + clientController.delete(2));
        System.out.println(ConsoleConstant.CONSOLE_READ_ALL_CLIENTS + clientController.readAll());

        System.out.println("\n----- RoomReservation -----");
        LocalDate startDay0 = LocalDate.of(2023,7,1);
        LocalDate startDay1 = LocalDate.of(2023,7,2);
        LocalDate startDay2 = LocalDate.of(2023,7,3);
        RoomReservation roomReservation0 = new RoomReservation(0,startDay0,client0,room0,2);
        RoomReservation roomReservation1 = new RoomReservation(1,startDay1,client1,room1,3);
        RoomReservation roomReservation2 = new RoomReservation(2,startDay2,client2,room2,5);
        System.out.println(ConsoleConstant.CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation0));
        System.out.println(ConsoleConstant.CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation1));
        System.out.println(ConsoleConstant.CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation2));
        System.out.println(ConsoleConstant.CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(0));
        System.out.println(ConsoleConstant.CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(1));
        System.out.println(ConsoleConstant.CONSOLE_READ_ROOM_RESERVATION + roomReservationController.read(2));
        RoomReservation roomReservation3 = new RoomReservation(3,startDay0,client2,room1,1);
        System.out.println(ConsoleConstant.CONSOLE_CREATE_ROOM_RESERVATION + roomReservationController.create(roomReservation3));
        System.out.println(roomReservationController.read(3));
    }
}
