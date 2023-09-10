package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_SORT_ROOMS_BY_PRICE;

public class Item1SortRoomsByPrice implements MenuItem {

    private final String nameItem;

    public Item1SortRoomsByPrice() {
        this.nameItem = MENU_ITEM_1_SORT_ROOMS_BY_PRICE;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
