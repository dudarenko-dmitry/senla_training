package pl.senla.hotel.ui.order;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.main.StartMenuMain;
import pl.senla.hotel.ui.services.StartUpdateHotelServiceList;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ExecutorOrder implements Executor {

    private static Executor executor;
    @GetInstance(beanName = "ControllerOrderCollection")
    private final ControllerOrder orderController;
    @GetInstance(beanName = "StartUpdateHotelServiceList")
    private final StartUpdateHotelServiceList updateHotelServiceList;
    @GetInstance(beanName = "NavigatorMainMenu")
    private final Navigator navigatorMain;
    @GetInstance(beanName = "ExecutorMain")
    private final Executor executorMain;
    @GetInstance(beanName = "NavigatorOrder")
    private final Navigator navigator;

    private ExecutorOrder(ControllerOrder orderController, StartUpdateHotelServiceList updateHotelServiceList,
                          Navigator navigatorMain, Executor executorMain, Navigator navigator) {
        this.orderController = orderController;
        this.updateHotelServiceList = updateHotelServiceList;
        this.navigatorMain = navigatorMain;
        this.executorMain = executorMain;
        this.navigator = navigator;
    }

    public static Executor getSingletonInstance(ControllerOrder orderController, StartUpdateHotelServiceList updateHotelServiceList,
                                                Navigator navigatorMain, Executor executorMain, Navigator navigator){
        if (executor == null) {
            executor = new ExecutorOrder(orderController, updateHotelServiceList, navigatorMain, executorMain, navigator);
        }
        return executor;
    }

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
            case 0 -> StartMenuMain.getSingletonInstance(navigatorMain, executorMain).runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuOrder.getSingletonInstance(navigator, executor).runMenu();
            }
        }
    }
}
