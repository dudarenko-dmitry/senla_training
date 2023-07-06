package pl.senla.hotel.UI.main;

import pl.senla.hotel.UI.MenuItem;

public class MainMenuItem1 implements MenuItem {

    private final String nameItem;

    public MainMenuItem1() {
        this.nameItem = "1. Hotel facilities operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
