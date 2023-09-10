package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_IMPORT_ROOM_DATA;

public class Item3ImportRoomData implements MenuItem {

    private final String nameItem;

    public Item3ImportRoomData() {
        this.nameItem = MENU_ITEM_3_IMPORT_ROOM_DATA;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
