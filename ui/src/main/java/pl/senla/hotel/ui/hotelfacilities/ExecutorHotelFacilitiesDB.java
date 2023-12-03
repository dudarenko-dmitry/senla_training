package pl.senla.hotel.ui.hotelfacilities;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@Component
@Qualifier("ExecutorHotelFacilitiesDB")
@NoArgsConstructor
public class ExecutorHotelFacilitiesDB implements Executor {

    @Autowired
    @Qualifier("StartMenuRoomDB")
    private StartMenu menuRoom;

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
