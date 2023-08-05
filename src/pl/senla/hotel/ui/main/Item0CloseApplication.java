package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class Item0CloseApplication implements MenuItem {

    private final String nameItem;

    public Item0CloseApplication() {
        this.nameItem = "0. Quit from program.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
