package pl.senla.hotel.ui.order;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.services.StartUpdateHotelServiceList;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ExecutorOrder implements Executor {

    @GetInstance(beanName = "StartMenuMain")
    private StartMenu startMenuMain;
    @GetInstance(beanName = "StartMenuOrder")
    private StartMenu startMenuOrder;
    @GetInstance(beanName = "ControllerOrderCollection")
    private ControllerOrder orderController;
    @GetInstance(beanName = "StartUpdateHotelServiceList")
    private StartUpdateHotelServiceList updateHotelServiceList;

    public ExecutorOrder() {}

    @Override
    public void execute(int userSelection) throws IllegalAccessException {
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
            case 0 -> startMenuMain.runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                startMenuOrder.runMenu();
            }
        }
    }
}
