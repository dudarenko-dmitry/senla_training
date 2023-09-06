package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_CREATE_ORDER;

public class Item3CreateOrder implements MenuItem {

    private final String nameItem;

    public Item3CreateOrder() {
        this.nameItem = MENU_ITEM_3_CREATE_ORDER;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
