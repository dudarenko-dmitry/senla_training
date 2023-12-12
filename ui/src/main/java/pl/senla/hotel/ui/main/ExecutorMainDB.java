package pl.senla.hotel.ui.main;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ApplicationContextConstant.CLOSE_APPLICATION;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@Component
@NoArgsConstructor
@Slf4j
public class ExecutorMainDB implements Executor {

    @Autowired
    @Qualifier("startMenuHotelFacilitiesDB")
    private StartMenu startMenuHotelFacilities;
    @Autowired
    @Qualifier("startMenuGuestDB")
    private StartMenu startMenuGuest;
    @Autowired
    @Qualifier("startMenuOrderDB")
    private StartMenu startMenuOrder;
    @Autowired
    @Qualifier("startMenuAnalyticsDB")
    private StartMenu startMenuAnalytics;
    @Autowired
    private Choice userChoice;

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        switch (menuPoint) {
            case 1 -> startMenuHotelFacilities.runMenu();
            case 2 -> startMenuGuest.runMenu();
            case 3 -> startMenuOrder.runMenu();
            case 4 -> startMenuAnalytics.runMenu();
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
