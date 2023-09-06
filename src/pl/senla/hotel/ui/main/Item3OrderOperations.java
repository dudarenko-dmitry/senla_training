package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_ORDER_OPERATIONS;

public class Item3OrderOperations implements MenuItem {

    private final String nameItem;

    public Item3OrderOperations() {
        this.nameItem = MENU_ITEM_3_ORDER_OPERATIONS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
