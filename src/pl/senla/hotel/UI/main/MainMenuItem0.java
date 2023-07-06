package pl.senla.hotel.UI.main;

import pl.senla.hotel.UI.MenuItem;

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
