package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_HOTEL_FACILITY_OPERATIONS;

public class Item1HotelFacilityOperations implements MenuItem {

    private final String nameItem;

    public Item1HotelFacilityOperations() {
        this.nameItem = MENU_ITEM_1_HOTEL_FACILITY_OPERATIONS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
