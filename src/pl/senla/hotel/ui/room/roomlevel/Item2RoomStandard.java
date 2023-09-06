package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ROOM_2;

public class Item2RoomStandard implements MenuItem {

    private final String nameItem;

    public Item2RoomStandard() {
        this.nameItem = MENU_ROOM_2;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
