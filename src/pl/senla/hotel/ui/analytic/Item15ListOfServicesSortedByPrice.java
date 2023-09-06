package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_15_LIST_OF_SERVICES_SORTED_BY_PRICE;

public class Item15ListOfServicesSortedByPrice implements MenuItem {

    private final String nameItem;

    public Item15ListOfServicesSortedByPrice() {
        this.nameItem = MENU_ITEM_15_LIST_OF_SERVICES_SORTED_BY_PRICE;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
