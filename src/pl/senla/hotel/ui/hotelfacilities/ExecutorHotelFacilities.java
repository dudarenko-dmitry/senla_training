package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorHotelFacilities implements Executor {

    private static Executor executor;
    @GetInstance(beanName = "StartMenuRoom")
    private final StartMenu menuRoom;
    private StartMenu menuTable;
    private StartMenu menuTransfer;
    @GetInstance(beanName = "NavigatorMainMenu")
    private final Navigator navigatorMain;
    @GetInstance(beanName = "ExecutorMain")
    private final Executor executorMain;


    private ExecutorHotelFacilities(StartMenu menuRoom, Navigator navigatorMain, Executor executorMain) {
        this.menuRoom = menuRoom;
        this.navigatorMain = navigatorMain;
        this.executorMain = executorMain;
//        this.menuTable = new StartMenuTable();
//        this.menuTransfer = new StartMenuTransfer();
    }

    public static Executor getSingletonInstance(StartMenu menuRoom, Navigator navigatorMain, Executor executorMain){
        if (executor == null) {
            executor = new ExecutorHotelFacilities(menuRoom, navigatorMain, executorMain);
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) throws IllegalAccessException {
        switch (userSelection) {
            case 1 -> menuRoom.runMenu();
            case 2 -> menuTable.runMenu();
            case 3 -> menuTransfer.runMenu();
            case 0 -> StartMenuMain.getSingletonInstance(navigatorMain, executorMain).runMenu();
            default -> {System.out.println(ERROR_INPUT);
                StartMenuMain.getSingletonInstance(navigatorMain, executorMain).runMenu();}
        }
    }
}
