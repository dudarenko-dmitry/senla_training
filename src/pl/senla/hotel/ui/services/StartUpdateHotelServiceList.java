package pl.senla.hotel.ui.services;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ui.Navigator;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_SERVICE_SELECT;

@AppComponent
public class StartUpdateHotelServiceList {

    @GetInstance(beanName = "NavigatorHotelService")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorUpdateHotelServiceList")
    private ExecutorUpdateHotelServiceList executor;

    public StartUpdateHotelServiceList() {}

    public boolean runMenu(int idOrderUpdate) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        navigator.buildMenu();
        System.out.println(MENU_HOTEL_SERVICE_SELECT);
        return executor.updateHotelServiceList(idOrderUpdate);
    }
}
