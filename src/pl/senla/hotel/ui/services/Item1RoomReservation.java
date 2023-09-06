package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_ROOM_RESERVATION;

public class Item1RoomReservation implements MenuItem {

    private final String nameItem;

    public Item1RoomReservation() {
        this.nameItem = MENU_ITEM_1_ROOM_RESERVATION;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
