package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item17Item15ListOfServicesAndRoomsSortByCategory implements MenuItem {

    private final String nameItem;

    public Item17Item15ListOfServicesAndRoomsSortByCategory() {
        this.nameItem = "17. Prices of services and rooms sort by category.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
