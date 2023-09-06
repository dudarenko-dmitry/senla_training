package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_CREATE_GUEST;

public class Item3CreateGuest implements MenuItem {

    private final String nameItem;

    public Item3CreateGuest() {
        this.nameItem = MENU_ITEM_3_CREATE_GUEST;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
