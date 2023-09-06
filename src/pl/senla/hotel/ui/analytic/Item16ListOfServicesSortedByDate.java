package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_16_LIST_OF_SERVICES_SORTED_BY_DATE;

public class Item16ListOfServicesSortedByDate implements MenuItem {

    private final String nameItem;

    public Item16ListOfServicesSortedByDate() {
        this.nameItem = MENU_ITEM_16_LIST_OF_SERVICES_SORTED_BY_DATE;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
