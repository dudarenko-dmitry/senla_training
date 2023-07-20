package pl.senla.hotel.ui.services;

import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ui.Navigator;

import java.util.List;
import java.util.Scanner;

public class StartCreateHotelServiceList {

    private final Navigator navigator;
    private final ExecutorCreateHotelServiceList executor;

    public StartCreateHotelServiceList() {
        this.navigator = new NavigatorHotelService();
        this.executor = new ExecutorCreateHotelServiceList();
    }

    public boolean runMenu() {
        Scanner sc = new Scanner(System.in);
        List<HotelService> guestServices;
        System.out.print("Input Guest's ID --> ");
        int idGuest = sc.nextInt();
        Order order = new Order(idGuest);
        int userChoice;
        do {
            navigator.buildMenu();
            userChoice = navigator.makeChoice();
            guestServices = executor.createHotelServiceList(idGuest, userChoice);
        } while (userChoice != 0);

        return true;
    }
}
