package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_READ_ALL_ROOMS;

public class Item1ReadAllRooms implements MenuItem {

    private final String nameItem;

    public Item1ReadAllRooms() {
        this.nameItem = MENU_ITEM_1_READ_ALL_ROOMS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
