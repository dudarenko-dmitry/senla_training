package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_9_COUNT_AVAILABLE_ROOMS;

public class Item9CountAvailableRooms implements MenuItem {

    private final String nameItem;

    public Item9CountAvailableRooms() {
        this.nameItem = MENU_ITEM_9_COUNT_AVAILABLE_ROOMS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
