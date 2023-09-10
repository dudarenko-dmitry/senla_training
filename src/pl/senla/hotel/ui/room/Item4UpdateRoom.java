package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_4_UPDATE_ROOM;

public class Item4UpdateRoom implements MenuItem {

    private final String nameItem;

    public Item4UpdateRoom() {
        this.nameItem = MENU_ITEM_4_UPDATE_ROOM;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
