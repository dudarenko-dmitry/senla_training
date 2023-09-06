package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ROOM_1;

public class Item1RoomEconomy implements MenuItem {

    private final String nameItem;

    public Item1RoomEconomy() {
        this.nameItem = MENU_ROOM_1;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
