package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class Item5InputOutputData implements MenuItem {

    private final String nameItem;

    public Item5InputOutputData() {
        this.nameItem = "5. Input/Output Operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
