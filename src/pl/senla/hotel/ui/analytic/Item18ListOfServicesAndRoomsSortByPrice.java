package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_18_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_PRICE;

public class Item18ListOfServicesAndRoomsSortByPrice implements MenuItem {

    private final String nameItem;

    public Item18ListOfServicesAndRoomsSortByPrice() {
        this.nameItem = MENU_ITEM_18_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_PRICE;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
