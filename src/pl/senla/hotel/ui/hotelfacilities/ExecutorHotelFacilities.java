package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorHotelFacilities implements Executor {

    @GetInstance(beanName = "StartMenuMain")
    private StartMenu startMenuMain;
    @GetInstance(beanName = "StartMenuHotelFacilities")
    private StartMenu startMenuHotelFacilities;
    @GetInstance(beanName = "StartMenuRoom")
    private StartMenu menuRoom;
//    private StartMenu menuTable;
//    private StartMenu menuTransfer;

    public ExecutorHotelFacilities() {}

    @Override
    public void execute(int userSelection) throws IllegalAccessException {
        switch (userSelection) {
            case 1 -> menuRoom.runMenu();
//            case 2 -> menuTable.runMenu();
//            case 3 -> menuTransfer.runMenu();
            case 0 -> startMenuMain.runMenu();
            default -> {System.out.println(ERROR_INPUT);
                startMenuHotelFacilities.runMenu();}
        }
    }
}
