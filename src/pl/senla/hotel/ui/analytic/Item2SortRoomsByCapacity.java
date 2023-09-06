package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_SORT_ROOMS_BY_CAPACITY;

public class Item2SortRoomsByCapacity implements MenuItem {

    private final String nameItem;

    public Item2SortRoomsByCapacity() {
        this.nameItem = MENU_ITEM_2_SORT_ROOMS_BY_CAPACITY;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
