package pl.senla.hotel.ui.main;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.application.annotation.StartMethod;
import pl.senla.hotel.application.annotation.StartPoint;
import pl.senla.hotel.application.di.DIContext;
import pl.senla.hotel.ie.serialization.Processor;
import pl.senla.hotel.ie.serialization.ProcessorSerializable;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
@StartPoint
public class StartMenuMain implements StartMenu {

    @GetInstance(beanName = "NavigatorMainMenu")
    private Navigator navigator;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;
    @GetInstance(beanName = "ExecutorMain")
    private Executor executor;

    public StartMenuMain() {}

    @StartMethod
    @Override
    public void runMenu() throws IllegalAccessException {
        DIContext context = DIContext.getContext();
        Processor processor = context.getBean(ProcessorSerializable.class);
        processor.loadHotelData();
        while (true) {
            navigator.buildMenu();
            int menuPoint = userChoice.makeChoice();
            executor.execute(menuPoint);
        }
    }
}
