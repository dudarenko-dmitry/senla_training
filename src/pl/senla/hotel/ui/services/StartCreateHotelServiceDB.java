package pl.senla.hotel.ui.services;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Navigator;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CREATE_SERVICE;

@AppComponent
public class StartCreateHotelServiceDB {

    @GetInstance(beanName = "NavigatorHotelService")
    private Navigator navigator;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;
    @GetInstance(beanName = "ExecutorCreateHotelServiceDB")
    private ExecutorCreateHotelServiceDB executor;

    public StartCreateHotelServiceDB() {}

    public boolean runMenu(int idOrder, int idGuest) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        int typeOfService = 1;
        while (typeOfService !=0 ) {
            navigator.buildMenu();
            typeOfService = makeChoice();
            if (typeOfService != 0) {
                System.out.println(CONSOLE_CREATE_SERVICE +
                        executor.createHotelServiceForGuest(idOrder, idGuest, typeOfService));
            }
        }
        return true; // check why
    }

    private int makeChoice(){
        System.out.print("Input your choice --> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
