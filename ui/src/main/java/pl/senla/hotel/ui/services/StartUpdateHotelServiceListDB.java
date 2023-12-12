package pl.senla.hotel.ui.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ui.Navigator;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_SERVICE_SELECT;

@Component
@Slf4j
public class StartUpdateHotelServiceListDB {

    @Autowired
    @Qualifier("navigatorHotelService")
    private Navigator navigator;
    @Autowired
    private ExecutorUpdateHotelServiceDB executor;

    public HotelService runMenu(int idOrderUpdate) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        navigator.buildMenu();
        log.info(MENU_HOTEL_SERVICE_SELECT);
        return executor.updateHotelServiceList(idOrderUpdate);
    }
}
