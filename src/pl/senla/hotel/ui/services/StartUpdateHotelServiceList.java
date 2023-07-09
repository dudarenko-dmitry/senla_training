package pl.senla.hotel.ui.services;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ui.Navigator;

import java.util.List;

public class StartUpdateHotelServiceList {

    private final Navigator navigator;
    private final ExecutorUpdateHotelServiceList executor;

    public StartUpdateHotelServiceList() {
        this.navigator = new NavigatorHotelService();
        this.executor = new ExecutorUpdateHotelServiceList();
    }

    public List<HotelService> runMenu(List<HotelService> services){
        navigator.buildMenu();
        int typeOsService = navigator.makeChoice();
        return executor.updateHotelServiceList(services, typeOsService);
    }
}
