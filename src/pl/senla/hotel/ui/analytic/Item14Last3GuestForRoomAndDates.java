package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_14_LAST_GUEST_FOR_ROOM_AND_DATES;

public class Item14Last3GuestForRoomAndDates implements MenuItem {

    private final String nameItem;

    public Item14Last3GuestForRoomAndDates() {
        this.nameItem = MENU_ITEM_14_LAST_GUEST_FOR_ROOM_AND_DATES;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
