package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_CREATE_ROOM;

public class Item3CreateRoom implements MenuItem {

    private final String nameItem;

    public Item3CreateRoom() {
        this.nameItem = MENU_ITEM_3_CREATE_ROOM;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
