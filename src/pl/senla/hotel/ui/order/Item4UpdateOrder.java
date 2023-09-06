package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_4_UPDATE_ORDER;

public class Item4UpdateOrder implements MenuItem {

    private final String nameItem;

    public Item4UpdateOrder() {
        this.nameItem = MENU_ITEM_4_UPDATE_ORDER;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
