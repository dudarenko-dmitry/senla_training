package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.Navigator;

import java.util.Scanner;

public class StartUpdateHotelServiceList {

    private final Navigator navigator;
    private final ExecutorUpdateHotelServiceList executor;

    public StartUpdateHotelServiceList() {
        this.navigator = new NavigatorHotelService();
        this.executor = new ExecutorUpdateHotelServiceList();
    }

    public boolean runMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Order's ID to Update -->");
        int idOrderUpdate = sc.nextInt();

        navigator.buildMenu();
        System.out.println("Select type of Hotel's Service you want to update.");
        int typeOsService = navigator.makeChoice();
        return executor.updateHotelServiceList(idOrderUpdate, typeOsService);
    }
}
