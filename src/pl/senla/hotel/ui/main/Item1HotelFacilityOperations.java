package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class Item1HotelFacilityOperations implements MenuItem {

    private final String nameItem;

    public Item1HotelFacilityOperations() {
        this.nameItem = "1. Hotel facilities operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
