package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_READ_ALL_ORDERS;

public class Item1ReadAllOrders implements MenuItem {

    private final String nameItem;

    public Item1ReadAllOrders() {
        this.nameItem = MENU_ITEM_1_READ_ALL_ORDERS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
