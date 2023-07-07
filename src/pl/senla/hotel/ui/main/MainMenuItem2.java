package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class MainMenuItem2 implements MenuItem {

    private final String nameItem;

    public MainMenuItem2() {
        this.nameItem = "2. Guests operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
