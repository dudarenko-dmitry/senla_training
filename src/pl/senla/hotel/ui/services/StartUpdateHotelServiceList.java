package pl.senla.hotel.ui.services;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_SERVICE_SELECT;

@AppComponent
public class StartUpdateHotelServiceList {

    @GetInstance(beanName = "NavigatorHotelService")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorUpdateHotelServiceList")
    private ExecutorUpdateHotelServiceList executor;

    public StartUpdateHotelServiceList() {}

    public boolean runMenu(int idOrderUpdate) throws IllegalAccessException {
        navigator.buildMenu();
        System.out.println(MENU_HOTEL_SERVICE_SELECT);
        int typeOsService = navigator.makeChoice();
        return executor.updateHotelServiceList(idOrderUpdate, typeOsService);
    }
}
