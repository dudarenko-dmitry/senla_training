package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_UPDATE_ROOM_AVAILABLE;

public class Item5UpdateRoomAvailable implements MenuItem {

    private final String nameItem;

    public Item5UpdateRoomAvailable() {
        this.nameItem = MENU_ITEM_5_UPDATE_ROOM_AVAILABLE;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
