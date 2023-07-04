package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class GuestItem0 implements MenuItem {

    private final String nameItem;

    public GuestItem0() {
        this.nameItem = "0. Quit to Main menu.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
