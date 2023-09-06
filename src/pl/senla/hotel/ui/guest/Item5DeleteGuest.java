package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_DELETE_GUEST;

public class Item5DeleteGuest implements MenuItem {

    private final String nameItem;

    public Item5DeleteGuest() {
        this.nameItem = MENU_ITEM_5_DELETE_GUEST;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
