package pl.senla.hotel.ui.order;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.controller.ControllerOrder;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.services.StartCreateHotelServiceDB;
import pl.senla.hotel.ui.services.StartUpdateHotelServiceListDB;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
@Slf4j
public class ExecutorOrderDB implements Executor {

    @GetInstance(beanName = "StartCreateHotelServiceDB")
    private StartCreateHotelServiceDB startCreateHotelService;
    @GetInstance(beanName = "ControllerOrderDB")
    private ControllerOrder orderController;
    @GetInstance(beanName = "StartUpdateHotelServiceListDB")
    private StartUpdateHotelServiceListDB startUpdateHotelServiceList;

    public ExecutorOrderDB() {}

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        switch (menuPoint) {
            case 1 -> log.info(CONSOLE_READ_ALL_ORDERS, orderController.readAll());
            case 2 -> {
                log.info(INPUT_ID_ORDER);
                int id = sc.nextInt();
                log.info(CONSOLE_READ_ORDER, orderController.read(id));
                System.out.println("!!!!!");
                log.info(CONSOLE_READ_ALL_SERVICES_FOR_ORDER, orderController.readAllIdServicesForOrder(id));
            }
            case 3 -> {
                log.info(INPUT_ID_GUEST);
                int idGuest = sc.nextInt();
                log.info(CONSOLE_CREATE_ORDER, orderController.create(String.valueOf(idGuest)));
                int idOrder = orderController.readAll()
                        .stream()
                        .map(Order::getIdOrder)
                        .max(Comparator.comparingInt(o -> o))
                        .orElse(-1);
                startCreateHotelService.runMenu(idOrder, idGuest);
                log.info(ADD_NEW_SERVICE_FOR_ORDER, orderController.addServicesToOrder(idOrder));
            }
            case 4 -> {
                log.info(INPUT_ID_ORDER);
                int idOrderUpdate = sc.nextInt();
                log.info(CONSOLE_CHANGE_ORDER, startUpdateHotelServiceList.runMenu(idOrderUpdate));
            }
            case 5 -> {
                log.info(INPUT_ID_ORDER);
                int idOrderDelete = sc.nextInt();
                log.info(CONSOLE_DELETE_ORDER, orderController.delete(idOrderDelete));
            }
            default -> {
                System.out.println(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }
}
