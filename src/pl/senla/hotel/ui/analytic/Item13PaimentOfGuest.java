package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item13PaimentOfGuest implements MenuItem {

    private final String nameItem;

    public Item13PaimentOfGuest() {
        this.nameItem = "13. The amount of payment for the room to be paid by the guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
