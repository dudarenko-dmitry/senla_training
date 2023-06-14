package pl.senla.lecture3.task4.controller;

import pl.senla.lecture3.task4.entity.Room;
import pl.senla.lecture3.task4.entity.RoomStatus;

import static pl.senla.lecture3.task4.constant.ConsoleConstant.*;

public class ConsoleCollection implements Console{

    private final Controller<Room> controllerRoom = new RoomControllerCollection();

    @Override
    public void start(){

        Room room0 = new Room(0,11,100, RoomStatus.FREE.getStatus());
        Room room1 = new Room(1,12,120, RoomStatus.FREE.getStatus());
        Room room2 = new Room(2,13,130, RoomStatus.FREE.getStatus());

        System.out.println(CONSOLE_CREATE_ROOM + controllerRoom.create(room0));
        System.out.println(CONSOLE_CREATE_ROOM + controllerRoom.create(room1));
        System.out.println(CONSOLE_CREATE_ROOM + controllerRoom.create(room2));
        System.out.println(controllerRoom.read(0));
        System.out.println(controllerRoom.read(1));
        System.out.println(controllerRoom.read(2));
        System.out.println(CONSOLE_READ_ALL_ROOMS + controllerRoom.readAll());

        room0.setRoomPrice(200); // make later input of new price via Scanner
        System.out.println(CONSOLE_CHANGE_ROOM + controllerRoom.update(room0));
        System.out.println(controllerRoom.read(0));
        System.out.println(CONSOLE_READ_ALL_ROOMS + controllerRoom.readAll());

        System.out.println(CONSOLE_DELETE_ROOM + controllerRoom.delete(2));
        System.out.println(CONSOLE_READ_ALL_ROOMS + controllerRoom.readAll());

    }
}
