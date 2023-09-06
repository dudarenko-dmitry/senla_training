package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_0_CLOSE_APPLICATION;

public class Item0CloseApplication implements MenuItem {

    private final String nameItem;

    public Item0CloseApplication() {
        this.nameItem = MENU_ITEM_0_CLOSE_APPLICATION;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
