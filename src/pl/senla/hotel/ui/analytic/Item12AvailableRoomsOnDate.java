package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_12_AVAILABLE_ROOMS_ON_DATE;

public class Item12AvailableRoomsOnDate implements MenuItem {

    private final String nameItem;

    public Item12AvailableRoomsOnDate() {
        this.nameItem = MENU_ITEM_12_AVAILABLE_ROOMS_ON_DATE;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
