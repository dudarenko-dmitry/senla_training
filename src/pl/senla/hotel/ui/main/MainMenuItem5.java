package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class MainMenuItem5 implements MenuItem {

    private final String nameItem;

    public MainMenuItem5() {
        this.nameItem = "5. Input/Output Operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
