package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_0_QUIT_TO_ORDER_MENU;

public class Item0QuitToOrderMenu implements MenuItem {

    private final String nameItem;

    public Item0QuitToOrderMenu() {
        this.nameItem = MENU_ITEM_0_QUIT_TO_ORDER_MENU;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
