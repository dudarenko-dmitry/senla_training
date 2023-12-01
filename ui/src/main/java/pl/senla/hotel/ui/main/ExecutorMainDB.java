package pl.senla.hotel.ui.main;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ApplicationContextConstant.CLOSE_APPLICATION;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
@Slf4j
public class ExecutorMainDB implements Executor {

    @GetInstance(beanName = "StartMenuHotelFacilitiesDB")
    private StartMenu startMenuHotelFacilities;
    @GetInstance(beanName = "StartMenuGuestDB")
    private StartMenu startMenuGuest;
    @GetInstance(beanName = "StartMenuOrderDB")
    private StartMenu startMenuOrder;
    @GetInstance(beanName = "StartMenuAnalyticsDB")
    private StartMenu startMenuAnalytics;
//    @GetInstance(beanName = "StartMenuImportExport")
//    private StartMenu startMenuImportExport;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;

    public ExecutorMainDB(){
    }

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        switch (menuPoint) {
            case 1 -> startMenuHotelFacilities.runMenu();
            case 2 -> startMenuGuest.runMenu();
            case 3 -> startMenuOrder.runMenu();
            case 4 -> startMenuAnalytics.runMenu();
//            case 5 -> startMenuImportExport.runMenu();
            case 0 -> {
                log.info(CLOSE_APPLICATION);
                System.exit(0);
            }
            default -> {
                log.info(ERROR_INPUT);
                menuPoint = userChoice.makeChoice();
                execute(menuPoint);
            }
        }
    }
}
