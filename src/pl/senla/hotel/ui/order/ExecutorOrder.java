package pl.senla.hotel.ui.order;

import pl.senla.hotel.controller.ControllerGuest;
import pl.senla.hotel.controller.ControllerGuestCollection;
import pl.senla.hotel.controller.ControllerOrder;
import pl.senla.hotel.controller.ControllerOrderCollection;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;
import pl.senla.hotel.ui.services.StartCreateHotelServiceList;
import pl.senla.hotel.ui.services.StartUpdateHotelServiceList;

import java.util.List;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT_NAVIGATE;

public class ExecutorOrder implements Executor {

    private final ControllerOrder orderController;
    private final ControllerGuest guestController;
    private final StartCreateHotelServiceList createHotelServiceList;
    private final StartUpdateHotelServiceList updateHotelServiceList;

    public ExecutorOrder() {
        this.orderController = new ControllerOrderCollection();
        this.guestController = new ControllerGuestCollection();
        this.createHotelServiceList = new StartCreateHotelServiceList();
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
                List<HotelService> hotelServices = createHotelServiceList.runMenu(idGuest);
                StringBuilder orderString = new StringBuilder()
                        .append(idGuest).append(":")
                        .append(hotelServices);
                System.out.println(CONSOLE_CREATE_ORDER + orderController.create(String.valueOf(orderString)));
            }
            case 4 -> {
                System.out.print("Input Order's ID to Update -->");
                int idUpdate = sc.nextInt();
                Order orderUpdated = orderController.read(idUpdate);
                List<HotelService> services = orderUpdated.getServices();
                services = updateHotelServiceList.runMenu(services);
                orderUpdated.setServices(services);
                System.out.println(CONSOLE_CREATE_ORDER + orderController.update(idUpdate, String.valueOf(services)));
            }
            case 5 -> {
                System.out.print("Input ID Order to Delete -->");
                int idOrderDelete = sc.nextInt();
                System.out.println(CONSOLE_DELETE_ORDER + orderController.delete(idOrderDelete));
            }
            case 0 -> new StartMenuMain().runMenu();
            default -> {
                System.out.println(ERROR_INPUT_NAVIGATE);
                new StartMenuOrder().runMenu();
            }
        }
    }


}
