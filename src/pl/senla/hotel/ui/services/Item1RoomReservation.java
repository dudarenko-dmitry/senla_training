package pl.senla.hotel.ui.services;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_ROOM_RESERVATION;

@Slf4j
public class Item1RoomReservation implements MenuItem {

    private final String nameItem;

    public Item1RoomReservation() {
        this.nameItem = MENU_ITEM_1_ROOM_RESERVATION;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
