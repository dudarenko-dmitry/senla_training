package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_7_GUESTS_SORTED_BY_NAME_AND_ROOMS;

public class Item7GuestsSortedByNameAndRooms implements MenuItem {

    private final String nameItem;

    public Item7GuestsSortedByNameAndRooms() {
        this.nameItem = MENU_ITEM_7_GUESTS_SORTED_BY_NAME_AND_ROOMS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
