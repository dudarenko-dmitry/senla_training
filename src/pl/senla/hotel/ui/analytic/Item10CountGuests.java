package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_10_COUNT_GUESTS;

public class Item10CountGuests implements MenuItem {

    private final String nameItem;

    public Item10CountGuests() {
        this.nameItem = MENU_ITEM_10_COUNT_GUESTS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
