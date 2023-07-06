package pl.senla.hotel.UI.main;

import pl.senla.hotel.UI.Executor;
import pl.senla.hotel.UI.StartMenu;
import pl.senla.hotel.UI.hotelfacilities.StartMenuHotelFacilities;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT_NAVIGATE;

public class ExecutorMain implements Executor {

    private final StartMenu startMenuHotelFacilities = new StartMenuHotelFacilities();
//    private final StartMenu startMenuGuest = new StartMenuGuest();
//    private final StartMenu startMenuOrder = new StartMenuOrder();
//    private final StartMenu startMenuAnalytics = new StartMenuAnalytics();

    @Override
    public void execute(int userSelection) {
        switch (userSelection) {
            case 1 -> startMenuHotelFacilities.runMenu();
//            case 2 -> startMenuGuest.runMenu();
//            case 3 -> startMenuOrder.runMenu();
//            case 4 -> startMenuAnalytics.runMenu();
            case 0 -> {
                System.out.println("Good-bye.");
                System.exit(0);
            }
            default -> System.out.println(ERROR_INPUT_NAVIGATE);
        }
    }
}
