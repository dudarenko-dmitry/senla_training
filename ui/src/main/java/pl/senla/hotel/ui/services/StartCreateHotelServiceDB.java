package pl.senla.hotel.ui.services;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Navigator;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CREATE_SERVICE;
import static pl.senla.hotel.constant.ConsoleConstant.INPUT_MENU_POINT;

@Component
@NoArgsConstructor
@Slf4j
public class StartCreateHotelServiceDB {

    @Autowired
    @Qualifier("NavigatorHotelService")
    private Navigator navigator;
    @Autowired
    private Choice userChoice;
    @Autowired
    private ExecutorCreateHotelServiceDB executor;

    public void runMenu(int idOrder, int idGuest) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        int typeOfService = 1;
        while (typeOfService !=0 ) {
            navigator.buildMenu();
            typeOfService = makeChoice();
            if (typeOfService != 0) {
                log.info(CONSOLE_CREATE_SERVICE,
                        executor.createHotelServiceForGuest(idOrder, idGuest, typeOfService));
            }
        }
    }

    private int makeChoice(){
        log.info(INPUT_MENU_POINT);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
