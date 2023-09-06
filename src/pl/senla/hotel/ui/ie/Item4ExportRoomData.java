package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_4_EXPORT_ROOM_DATA;

public class Item4ExportRoomData implements MenuItem {

    private final String nameItem;

    public Item4ExportRoomData() {
        this.nameItem = MENU_ITEM_4_EXPORT_ROOM_DATA;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
