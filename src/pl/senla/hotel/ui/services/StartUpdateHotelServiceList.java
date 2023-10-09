package pl.senla.hotel.ui.services;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_SERVICE_SELECT;

@AppComponent
public class StartUpdateHotelServiceList {

    private static StartUpdateHotelServiceList startUpdateHotelServiceList;
    @GetInstance(beanName = "NavigatorHotelService")
    private final Navigator navigator;
    @GetInstance(beanName = "ExecutorUpdateHotelServiceList")
    private final ExecutorUpdateHotelServiceList executor;

    private StartUpdateHotelServiceList(Navigator navigator, ExecutorUpdateHotelServiceList executor) {
        this.navigator = navigator;
        this.executor = executor;
    }

    public static StartUpdateHotelServiceList getSingletonInstance(Navigator navigator,
                                                                   ExecutorUpdateHotelServiceList executor){
        if (startUpdateHotelServiceList == null) {
            startUpdateHotelServiceList = new StartUpdateHotelServiceList(navigator, executor);
        }
        return startUpdateHotelServiceList;
    }

    public boolean runMenu(int idOrderUpdate) throws IllegalAccessException {
        navigator.buildMenu();
        System.out.println(MENU_HOTEL_SERVICE_SELECT);
        int typeOsService = navigator.makeChoice();
        return executor.updateHotelServiceList(idOrderUpdate, typeOsService);
    }
}
