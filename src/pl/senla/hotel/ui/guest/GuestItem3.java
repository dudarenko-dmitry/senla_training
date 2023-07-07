package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class GuestItem3 implements MenuItem {

    private final String nameItem;

    public GuestItem3() {
        this.nameItem = "3. Create new Guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
