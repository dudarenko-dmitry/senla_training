package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.analytic.StartMenuAnalytics;
import pl.senla.hotel.ui.guest.StartMenuGuest;
import pl.senla.hotel.ui.hotelfacilities.StartMenuHotelFacilities;
import pl.senla.hotel.ui.order.StartMenuOrder;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

public class ExecutorMain implements Executor {

    private final StartMenu startMenuHotelFacilities;
    private final StartMenu startMenuGuest;
    private final StartMenu startMenuOrder;
    private final StartMenu startMenuAnalytics;

    public ExecutorMain() {
        this.startMenuHotelFacilities  = StartMenuHotelFacilities.getStartMenuHotelFacilities();
        this.startMenuGuest = StartMenuGuest.getStartMenuGuest();
        this.startMenuOrder = StartMenuOrder.getStartMenuOrder();
        this.startMenuAnalytics = StartMenuAnalytics.getStartMenuAnalytics();
    }

    @Override
    public void execute(int userSelection) {
        switch (userSelection) {
            case 1 -> startMenuHotelFacilities.runMenu();
            case 2 -> startMenuGuest.runMenu();
            case 3 -> startMenuOrder.runMenu();
            case 4 -> startMenuAnalytics.runMenu();
            case 0 -> {
                System.out.println("Good-bye.");
                System.exit(0);
            }
            default -> {
                System.out.println(ERROR_INPUT);
                new StartMenuMain().runMenu();
            }
        }
    }
}
