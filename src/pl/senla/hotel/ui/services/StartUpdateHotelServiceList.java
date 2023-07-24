package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.Navigator;

public class StartUpdateHotelServiceList {

    private final Navigator navigator;
    private final ExecutorUpdateHotelServiceList executor;

    public StartUpdateHotelServiceList() {
        this.navigator = new NavigatorHotelService();
        this.executor = new ExecutorUpdateHotelServiceList();
    }

    public boolean runMenu(int idOrderUpdate){
        navigator.buildMenu();
        System.out.println("Select type of Hotel's Service you want to update.");
        int typeOsService = navigator.makeChoice();
        return executor.updateHotelServiceList(idOrderUpdate, typeOsService);
    }
}
