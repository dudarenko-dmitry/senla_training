package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_SORT_AVAILABLE_ROOMS_BY_CAPACITY;

public class Item5SortAvailableRoomsByCapacity implements MenuItem {

    private final String nameItem;

    public Item5SortAvailableRoomsByCapacity() {
        this.nameItem = MENU_ITEM_5_SORT_AVAILABLE_ROOMS_BY_CAPACITY;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
