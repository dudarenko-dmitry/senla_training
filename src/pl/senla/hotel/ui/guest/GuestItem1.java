package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class GuestItem1 implements MenuItem {

    private final String nameItem;

    public GuestItem1() {
        this.nameItem = "1. Read all Guests.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
