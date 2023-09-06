package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_17_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_CATEGORY;

public class Item17ListOfServicesAndRoomsSortByCategory implements MenuItem {

    private final String nameItem;

    public Item17ListOfServicesAndRoomsSortByCategory() {
        this.nameItem = MENU_ITEM_17_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_CATEGORY;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
