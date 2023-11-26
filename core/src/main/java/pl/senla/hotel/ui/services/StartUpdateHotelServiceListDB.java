package pl.senla.hotel.ui.services;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ui.Navigator;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_SERVICE_SELECT;

@AppComponent
@Slf4j
public class StartUpdateHotelServiceListDB {

    @GetInstance(beanName = "NavigatorHotelService")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorUpdateHotelServiceDB")
    private ExecutorUpdateHotelServiceDB executor;

    public StartUpdateHotelServiceListDB() {}

    public boolean runMenu(int idOrderUpdate) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        navigator.buildMenu();
        log.info(MENU_HOTEL_SERVICE_SELECT);
        return executor.updateHotelServiceList(idOrderUpdate);
    }
}
