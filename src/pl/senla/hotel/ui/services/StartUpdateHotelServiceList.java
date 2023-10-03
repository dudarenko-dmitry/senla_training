package pl.senla.hotel.ui.services;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_SERVICE_SELECT;

public class StartUpdateHotelServiceList {

    private static StartUpdateHotelServiceList startUpdateHotelServiceList;
    private final Navigator navigator;
    private final ExecutorUpdateHotelServiceList executor;

    private StartUpdateHotelServiceList(Configuration appConfiguration) {
        this.navigator = NavigatorHotelService.getNavigatorHotelService();
        this.executor = ExecutorUpdateHotelServiceList.getExecutorUpdateHotelServiceList(appConfiguration);
    }

    public static StartUpdateHotelServiceList getStartUpdateHotelServiceList(Configuration appConfiguration){
        if (startUpdateHotelServiceList == null) {
            startUpdateHotelServiceList = new StartUpdateHotelServiceList(appConfiguration);
        }
        return startUpdateHotelServiceList;
    }

    public boolean runMenu(int idOrderUpdate){
        navigator.buildMenu();
        System.out.println(MENU_HOTEL_SERVICE_SELECT);
        int typeOsService = navigator.makeChoice();
        return executor.updateHotelServiceList(idOrderUpdate, typeOsService);
    }
}
