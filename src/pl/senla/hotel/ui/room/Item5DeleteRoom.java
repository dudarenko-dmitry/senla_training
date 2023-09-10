package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_DELETE_ROOM;

public class Item5DeleteRoom implements MenuItem {

    private final String nameItem;

    public Item5DeleteRoom() {
        this.nameItem = MENU_ITEM_5_DELETE_ROOM;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
