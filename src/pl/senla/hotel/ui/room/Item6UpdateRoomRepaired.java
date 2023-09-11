package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_6_UPDATE_ROOM_REPAIRED;

public class Item6UpdateRoomRepaired implements MenuItem {

    private final String nameItem;

    public Item6UpdateRoomRepaired() {
        this.nameItem = MENU_ITEM_6_UPDATE_ROOM_REPAIRED;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
