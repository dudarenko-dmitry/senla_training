package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ROOM_3;

public class Item3RoomLux implements MenuItem {

    private final String nameItem;

    public Item3RoomLux() {
        this.nameItem = MENU_ROOM_3;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
