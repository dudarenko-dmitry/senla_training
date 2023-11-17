package pl.senla.hotel.ui.services;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Navigator;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CREATE_SERVICE;
import static pl.senla.hotel.constant.ConsoleConstant.INPUT_MENU_POINT;

@AppComponent
@Slf4j
public class StartCreateHotelServiceDB {

    @GetInstance(beanName = "NavigatorHotelService")
    private Navigator navigator;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;
    @GetInstance(beanName = "ExecutorCreateHotelServiceDB")
    private ExecutorCreateHotelServiceDB executor;

    public StartCreateHotelServiceDB() {}

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
