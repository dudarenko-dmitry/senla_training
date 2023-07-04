package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

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
