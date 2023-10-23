package pl.senla.hotel.ui.services;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CREATE_SERVICE;

@AppComponent
public class StartCreateHotelService {

    @GetInstance(beanName = "NavigatorHotelService")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorCreateHotelService")
    private ExecutorCreateHotelService executor;

    public StartCreateHotelService() {}

    public boolean runMenu(int idOrder, int idGuest) throws IllegalAccessException {
        navigator.buildMenu();
        System.out.println(CONSOLE_CREATE_SERVICE + executor.createHotelServiceForGuest(idOrder, idGuest));
        return true;
    }
}
