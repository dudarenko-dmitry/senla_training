package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorHotelFacilities implements Executor {

    @GetInstance(beanName = "StartMenuRoom")
    private StartMenu menuRoom;
//    private StartMenu menuTable;
//    private StartMenu menuTransfer;

    public ExecutorHotelFacilities() {}

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        switch (menuPoint) {
            case 1 -> menuRoom.runMenu();
//            case 2 -> menuTable.runMenu();
//            case 3 -> menuTransfer.runMenu();
            default -> {System.out.println(ERROR_INPUT);
                execute(menuPoint);}
        }
    }
}
