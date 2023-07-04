package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class GuestItem4 implements MenuItem {

    private final String nameItem;

    public GuestItem4() {
        this.nameItem = "4. Update Guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
