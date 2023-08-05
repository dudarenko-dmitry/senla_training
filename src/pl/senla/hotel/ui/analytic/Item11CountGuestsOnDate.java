package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item11CountGuestsOnDate implements MenuItem {

    private final String nameItem;

    public Item11CountGuestsOnDate() {
        this.nameItem = "11. Total number of guests on date.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
