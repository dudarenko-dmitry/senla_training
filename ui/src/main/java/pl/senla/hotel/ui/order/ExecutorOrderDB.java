package pl.senla.hotel.ui.order;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.controller.ControllerOrder;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.services.StartCreateHotelServiceDB;
import pl.senla.hotel.ui.services.StartUpdateHotelServiceListDB;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@Component
@NoArgsConstructor
@Slf4j
public class ExecutorOrderDB implements Executor {

    @Autowired
    private StartCreateHotelServiceDB startCreateHotelService;
    @Autowired
    private ControllerOrder orderController;
    @Autowired
    private StartUpdateHotelServiceListDB startUpdateHotelServiceList;

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
                orderController.addServicesToOrder(idOrder);
                log.info(ADD_NEW_SERVICE_FOR_ORDER);
            }
            case 4 -> {
                log.info(INPUT_ID_ORDER);
                int idOrderUpdate = sc.nextInt();
                log.info(CONSOLE_CHANGE_ORDER, startUpdateHotelServiceList.runMenu(idOrderUpdate));
            }
            case 5 -> {
                log.info(INPUT_ID_ORDER);
                int idOrderDelete = sc.nextInt();
                orderController.delete(idOrderDelete);
                log.info(CONSOLE_DELETE_ORDER);
            }
            default -> {
                System.out.println(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }
}
