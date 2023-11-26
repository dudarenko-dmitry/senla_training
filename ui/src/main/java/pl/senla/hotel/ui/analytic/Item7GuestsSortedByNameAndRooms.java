package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_7_GUESTS_SORTED_BY_NAME_AND_ROOMS;

@Slf4j
public class Item7GuestsSortedByNameAndRooms implements MenuItem {

    private final String nameItem;

    public Item7GuestsSortedByNameAndRooms() {
        this.nameItem = MENU_ITEM_7_GUESTS_SORTED_BY_NAME_AND_ROOMS;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
