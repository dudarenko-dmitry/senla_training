package pl.senla.hotel.ui.main;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ie.serialization.Processor;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ExecutorMainDB implements Executor {

    @GetInstance(beanName = "StartMenuHotelFacilitiesDB")
    private StartMenu startMenuHotelFacilities;
    @GetInstance(beanName = "StartMenuGuestDB")
    private StartMenu startMenuGuest;
    @GetInstance(beanName = "StartMenuOrderDB")
    private StartMenu startMenuOrder;
    @GetInstance(beanName = "StartMenuAnalyticsDB")
    private StartMenu startMenuAnalytics;
    @GetInstance(beanName = "StartMenuImportExport")
    private StartMenu startMenuImportExport;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;
//    @GetInstance(beanName = "ProcessorSerializable")
//    private Processor processor;

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
            case 5 -> startMenuImportExport.runMenu();
            case 0 -> {
//                processor.saveHotelData();
                System.out.println("Good-bye.");
                System.exit(0);
            }
            default -> {
                System.out.println(ERROR_INPUT);
                menuPoint = userChoice.makeChoice();
                execute(menuPoint);
            }
        }
    }
}
