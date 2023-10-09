package pl.senla.hotel.ui.services;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CREATE_SERVICE;

@AppComponent
public class StartCreateHotelService {

    private static StartCreateHotelService startCreateHotelService;
    @GetInstance(beanName = "NavigatorHotelService")
    private final Navigator navigator;
    @GetInstance(beanName = "ExecutorCreateHotelService")
    private final ExecutorCreateHotelService executor;

    private StartCreateHotelService(Navigator navigator, ExecutorCreateHotelService executor) {
        this.navigator = navigator;
        this.executor = executor;
    }

    public static StartCreateHotelService getSingletonInstance(Navigator navigator,
                                                               ExecutorCreateHotelService executor){
        if (startCreateHotelService == null) {
            startCreateHotelService = new StartCreateHotelService(navigator, executor);
        }
        return startCreateHotelService;
    }

    public boolean runMenu(int idOrder, int idGuest) {
        int userChoice;
        do {
            navigator.buildMenu();
            userChoice = navigator.makeChoice();
            System.out.println(CONSOLE_CREATE_SERVICE + executor.createHotelServiceForGuest(idOrder, idGuest, userChoice));
        } while (userChoice != 0);
        return true;
    }
}
