package pl.senla.hotel.UI.main;

import pl.senla.hotel.UI.MenuItem;

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
