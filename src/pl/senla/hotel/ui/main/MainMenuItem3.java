package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class MainMenuItem3 implements MenuItem {

    private final String nameItem;

    public MainMenuItem3() {
        this.nameItem = "3. Orders' operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
