package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.Navigator;

public class StartUpdateHotelServiceList {

    private static StartUpdateHotelServiceList startUpdateHotelServiceList;
    private final Navigator navigator;
    private final ExecutorUpdateHotelServiceList executor;

    private StartUpdateHotelServiceList() {
        this.navigator = NavigatorHotelService.getNavigatorHotelService();
        this.executor = ExecutorUpdateHotelServiceList.getExecutorUpdateHotelServiceList();
    }

    public static StartUpdateHotelServiceList getStartUpdateHotelServiceList(){
        if (startUpdateHotelServiceList == null) {
            startUpdateHotelServiceList = new StartUpdateHotelServiceList();
        }
        return startUpdateHotelServiceList;
    }

    public boolean runMenu(int idOrderUpdate){
        navigator.buildMenu();
        System.out.println("Select type of Hotel's Service you want to update.");
        int typeOsService = navigator.makeChoice();
        return executor.updateHotelServiceList(idOrderUpdate, typeOsService);
    }
}
