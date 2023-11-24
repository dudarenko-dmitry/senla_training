package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ExecutorHotelFacilitiesDB implements Executor {

    @GetInstance(beanName = "StartMenuRoomDB")
    private StartMenu menuRoom;

    public ExecutorHotelFacilitiesDB() {}

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        if (menuPoint == 1) {
            menuRoom.runMenu();
        } else {
            System.out.println(ERROR_INPUT);
            execute(menuPoint);
        }
    }
}
