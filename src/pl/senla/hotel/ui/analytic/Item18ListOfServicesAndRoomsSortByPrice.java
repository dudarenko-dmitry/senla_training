package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item18ListOfServicesAndRoomsSortByPrice implements MenuItem {

    private final String nameItem;

    public Item18ListOfServicesAndRoomsSortByPrice() {
        this.nameItem = "18. Prices of services and rooms sort by price.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
