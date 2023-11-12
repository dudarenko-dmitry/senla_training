package pl.senla.hotel.ui.order;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.services.StartCreateHotelService;
import pl.senla.hotel.ui.services.StartUpdateHotelServiceList;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ExecutorOrder implements Executor {

    @GetInstance(beanName = "StartCreateHotelService")
    private StartCreateHotelService startCreateHotelService;
    @GetInstance(beanName = "ControllerOrderCollection")
    private ControllerOrder orderController;
    @GetInstance(beanName = "StartUpdateHotelServiceList")
    private StartUpdateHotelServiceList startUpdateHotelServiceList;

    public ExecutorOrder() {}

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        switch (menuPoint) {
            case 1 -> System.out.println(CONSOLE_READ_ALL_ORDERS + orderController.readAll());
            case 2 -> {
                System.out.print("Input Order's ID --> ");
                int id = sc.nextInt();
                System.out.println(CONSOLE_READ_ALL_SERVICES_FOR_ORDER + orderController.readAllIdServicesForOrder(id));
            }
            case 3 -> {
                System.out.print("Input Guest's ID --> ");
                int idGuest = sc.nextInt();
                System.out.println(CONSOLE_CREATE_ORDER + orderController.create(String.valueOf(idGuest)));
                int idOrder = orderController.readAll()
                        .stream()
                        .map(Order::getIdOrder)
                        .max(Comparator.comparingInt(o -> o))
                        .orElse(-1);
                startCreateHotelService.runMenu(idOrder, idGuest);
                System.out.println("Add new services to order: " + orderController.addServicesToOrder(idOrder));
            }
            case 4 -> {
                System.out.print("Input Order's ID to Update --> ");
                int idOrderUpdate = sc.nextInt();
                System.out.println(CONSOLE_CHANGE_ORDER + startUpdateHotelServiceList.runMenu(idOrderUpdate));
            }
            case 5 -> {
                System.out.print("Input ID Order to Delete --> ");
                int idOrderDelete = sc.nextInt();
                System.out.println(CONSOLE_DELETE_ORDER + orderController.delete(idOrderDelete));
            }
            default -> {
                System.out.println(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }
}
