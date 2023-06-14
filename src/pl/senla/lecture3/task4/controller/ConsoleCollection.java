package pl.senla.lecture3.task4.controller;

import pl.senla.lecture3.task4.entity.Client;
import pl.senla.lecture3.task4.entity.Room;
import pl.senla.lecture3.task4.entity.RoomStatus;

import static pl.senla.lecture3.task4.constant.ConsoleConstant.*;

public class ConsoleCollection implements Console{

    private final Controller<Room> roomController = new RoomController();
    private final Controller<Client> clientController = new ClientController();

    @Override
    public void start(){

        System.out.println("----- Room -----");
        Room room0 = new Room(0,11,100, RoomStatus.FREE.getStatus());
        Room room1 = new Room(1,12,120, RoomStatus.FREE.getStatus());
        Room room2 = new Room(2,13,130, RoomStatus.FREE.getStatus());

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

        System.out.println("----- Client -----");
        Client client0 = new Client(0, "Tom", 351434000, null);//change after creating Orders!!!
        Client client1 = new Client(1, "John", 380452004, null);//change after creating Orders!!!
        Client client2 = new Client(2, "Sam", 905350895, null);//change after creating Orders!!!

        System.out.println(CONSOLE_CREATE_CLIENT + clientController.create(client0));
        System.out.println(CONSOLE_CREATE_CLIENT + clientController.create(client1));
        System.out.println(CONSOLE_CREATE_CLIENT + clientController.create(client2));
        System.out.println(clientController.read(0));
        System.out.println(clientController.read(1));
        System.out.println(clientController.read(2));
        System.out.println(CONSOLE_READ_ALL_CLIENTS + clientController.readAll());

        client0.setPhoneNumber(378340012); // create later methods for changing of different attributes
        System.out.println(CONSOLE_CHANGE_CLIENT + clientController.update(client0));
        System.out.println(clientController.read(0));
        System.out.println(CONSOLE_READ_ALL_CLIENTS + clientController.readAll());

        System.out.println(CONSOLE_DELETE_CLIENT + clientController.delete(2));
        System.out.println(CONSOLE_READ_ALL_CLIENTS + clientController.readAll());


    }
}
