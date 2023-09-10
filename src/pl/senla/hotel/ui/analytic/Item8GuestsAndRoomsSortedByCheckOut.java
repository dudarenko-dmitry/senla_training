package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_8_GUESTS_AND_ROOMS_SORTED_BY_CHECK_OUT;

public class Item8GuestsAndRoomsSortedByCheckOut implements MenuItem {

    private final String nameItem;

    public Item8GuestsAndRoomsSortedByCheckOut() {
        this.nameItem = MENU_ITEM_8_GUESTS_AND_ROOMS_SORTED_BY_CHECK_OUT;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
