package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_READ_GUEST;

public class Item2ReadGuest implements MenuItem {

    private final String nameItem;

    public Item2ReadGuest() {
        this.nameItem = MENU_ITEM_2_READ_GUEST;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
