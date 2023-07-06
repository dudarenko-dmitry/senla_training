package pl.senla.hotel.UI.main;

import pl.senla.hotel.UI.MenuItem;

public class MainMenuItem4 implements MenuItem {

    private final String nameItem;

    public MainMenuItem4() {
        this.nameItem = "4. Analytics reports.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
