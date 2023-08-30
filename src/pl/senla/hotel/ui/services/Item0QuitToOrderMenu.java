package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

public class Item0QuitToOrderMenu implements MenuItem {

    private final String nameItem;

    public Item0QuitToOrderMenu() {
        this.nameItem = "0. Save List and Quit to Order menu.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
