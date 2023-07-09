package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class GuestItem5 implements MenuItem {

    private final String nameItem;

    public GuestItem5() {
        this.nameItem = "5. Delete Guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
