package pl.senla.hotel.ui.order;

import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;
//import pl.senla.hotel.ui.services.StartCreateHotelService;
import pl.senla.hotel.ui.services.StartUpdateHotelServiceList;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

public class ExecutorOrder implements Executor {

    private final ControllerOrder orderController;
//    private final StartCreateHotelService createHotelServiceList;
    private final StartUpdateHotelServiceList updateHotelServiceList;

    public ExecutorOrder() {
        this.orderController = ControllerOrderCollection.getControllerOrder();
//        this.createHotelServiceList = new StartCreateHotelService();
        this.updateHotelServiceList = new StartUpdateHotelServiceList();
    }

    @Override
    public void execute(int userSelection) {
        Scanner sc = new Scanner(System.in);
        switch (userSelection) {
            case 1 -> System.out.println(CONSOLE_READ_ALL_ORDERS + orderController.readAll());
            case 2 -> {
                System.out.print("Input Order's ID --> ");
                int id = sc.nextInt();
                System.out.println(CONSOLE_READ_ORDER + orderController.read(id));
            }
            case 3 -> {
                System.out.print("Input Guest's ID --> ");
                int idGuest = sc.nextInt();
                System.out.println(CONSOLE_CREATE_ORDER + orderController.create(String.valueOf(idGuest)));
//                System.out.println(CONSOLE_CREATE_ORDER + createHotelServiceList.runMenu(idGuest)); // CHECK This !!!!!!!!
            }
            case 4 -> {
                System.out.print("Input Order's ID to Update --> ");
                int idOrderUpdate = sc.nextInt();
                System.out.println(CONSOLE_CHANGE_ORDER + updateHotelServiceList.runMenu(idOrderUpdate)); // CHECK This !!!!!!!!
            }
            case 5 -> {
                System.out.print("Input ID Order to Delete --> ");
                int idOrderDelete = sc.nextInt();
                System.out.println(CONSOLE_DELETE_ORDER + orderController.delete(idOrderDelete));
            }
            case 0 -> new StartMenuMain().runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                new StartMenuOrder().runMenu();
            }
        }
    }


}
