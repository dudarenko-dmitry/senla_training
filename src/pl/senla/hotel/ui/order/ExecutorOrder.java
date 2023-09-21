package pl.senla.hotel.ui.order;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;
import pl.senla.hotel.ui.services.StartUpdateHotelServiceList;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

public class ExecutorOrder implements Executor {

    private static Executor executor;
    private final ControllerOrder orderController;
    private final StartUpdateHotelServiceList updateHotelServiceList;
    private final Configuration configuration;

    private ExecutorOrder(Configuration appConfiguration) {
        this.configuration = appConfiguration;
        this.orderController = ControllerOrderCollection.getControllerOrder();
        this.updateHotelServiceList = StartUpdateHotelServiceList.getStartUpdateHotelServiceList(configuration);
    }

    public static Executor getExecutorOrder(Configuration appConfiguration){
        if (executor == null) {
            executor = new ExecutorOrder(appConfiguration);
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) {
        Scanner sc = new Scanner(System.in);
        switch (userSelection) {
            case 1 -> System.out.println(CONSOLE_READ_ALL_ORDERS + orderController.readAll());
            case 2 -> {
                System.out.print("Input Order's ID --> ");
                int id = sc.nextInt();
                System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_ORDER + orderController.readAllServicesForOrder(id));
            }
            case 3 -> {
                System.out.print("Input Guest's ID --> ");
                int idGuest = sc.nextInt();
                System.out.println(CONSOLE_CREATE_ORDER + orderController.create(String.valueOf(idGuest)));
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
            case 0 -> StartMenuMain.getStartMenu(configuration).runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuOrder.getStartMenuOrder(configuration).runMenu();
            }
        }
    }
}
