package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_4_SORT_AVAILABLE_ROOMS_BY_PRICE;

public class Item4SortAvailableRoomsByPrice implements MenuItem {

    private final String nameItem;

    public Item4SortAvailableRoomsByPrice() {
        this.nameItem = MENU_ITEM_4_SORT_AVAILABLE_ROOMS_BY_PRICE;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
