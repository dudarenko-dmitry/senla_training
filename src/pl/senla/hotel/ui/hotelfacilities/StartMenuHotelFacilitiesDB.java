package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

@AppComponent
public class StartMenuHotelFacilitiesDB implements StartMenu {

    @GetInstance(beanName = "NavigatorHotelFacilities")
    private Navigator navigator;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;
    @GetInstance(beanName = "ExecutorHotelFacilitiesDB")
    private Executor executor;

    public StartMenuHotelFacilitiesDB() {}

    public void runMenu() throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        int menuPoint = 1;
        while (menuPoint != 0) {
            navigator.buildMenu();
            menuPoint = userChoice.makeChoice();
            if (menuPoint != 0) {
                executor.execute(menuPoint);
            }
        }
    }
}
