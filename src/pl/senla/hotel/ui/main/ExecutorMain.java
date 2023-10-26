package pl.senla.hotel.ui.main;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.application.di.DIContext;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Hotel;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ie.serialization.Processor;
import pl.senla.hotel.ie.serialization.ProcessorSerializable;
import pl.senla.hotel.storage.*;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;

import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ExecutorMain implements Executor {

    @GetInstance(beanName = "StartMenuHotelFacilities")
    private StartMenu startMenuHotelFacilities;
    @GetInstance(beanName = "StartMenuGuest")
    private StartMenu startMenuGuest;
    @GetInstance(beanName = "StartMenuOrder")
    private StartMenu startMenuOrder;
    @GetInstance(beanName = "StartMenuAnalytics")
    private StartMenu startMenuAnalytics;
    @GetInstance(beanName = "StartMenuImportExport")
    private StartMenu startMenuImportExport;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;
    @GetInstance(beanName = "ProcessorSerializable")
    private Processor processor;

    public ExecutorMain(){
    }

    @Override
    public void execute(int menuPoint) throws IllegalAccessException {
        switch (menuPoint) {
            case 1 -> startMenuHotelFacilities.runMenu();
            case 2 -> startMenuGuest.runMenu();
            case 3 -> startMenuOrder.runMenu();
            case 4 -> startMenuAnalytics.runMenu();
            case 5 -> startMenuImportExport.runMenu();
            case 0 -> {
                processor.saveHotelData();
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
