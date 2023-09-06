package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_6_SORT_AVAILABLE_ROOMS_BY_LEVEL;

public class Item6SortAvailableRoomsByLevel implements MenuItem {

    private final String nameItem;

    public Item6SortAvailableRoomsByLevel() {
        this.nameItem = MENU_ITEM_6_SORT_AVAILABLE_ROOMS_BY_LEVEL;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
