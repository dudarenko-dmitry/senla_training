package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_4_UPDATE_GUEST;

public class Item4UpdateGuest implements MenuItem {

    private final String nameItem;

    public Item4UpdateGuest() {
        this.nameItem = MENU_ITEM_4_UPDATE_GUEST;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
