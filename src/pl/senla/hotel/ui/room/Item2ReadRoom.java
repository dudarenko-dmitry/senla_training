package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_READ_ROOM;

public class Item2ReadRoom implements MenuItem {

    private final String nameItem;

    public Item2ReadRoom() {
        this.nameItem = MENU_ITEM_2_READ_ROOM;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
