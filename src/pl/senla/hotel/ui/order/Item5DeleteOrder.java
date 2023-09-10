package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_DELETE_ORDER;

public class Item5DeleteOrder implements MenuItem {

    private final String nameItem;

    public Item5DeleteOrder() {
        this.nameItem = MENU_ITEM_5_DELETE_ORDER;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
