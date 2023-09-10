package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_RESTAURANT_RESERVATION;

public class Item2RestaurantReservation implements MenuItem {

    private final String nameItem;

    public Item2RestaurantReservation() {
        this.nameItem = MENU_ITEM_2_RESTAURANT_RESERVATION;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
