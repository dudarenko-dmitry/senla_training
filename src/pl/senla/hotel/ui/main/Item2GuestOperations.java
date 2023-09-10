package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_GUEST_OPERATIONS;

public class Item2GuestOperations implements MenuItem {

    private final String nameItem;

    public Item2GuestOperations() {
        this.nameItem = MENU_ITEM_2_GUEST_OPERATIONS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
