package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class GuestItem2 implements MenuItem {

    private final String nameItem;

    public GuestItem2() {
        this.nameItem = "2. Read Guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
