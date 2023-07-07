package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class MainMenuItem0 implements MenuItem {

    private final String nameItem;

    public MainMenuItem0() {
        this.nameItem = "0. Quit from program.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
