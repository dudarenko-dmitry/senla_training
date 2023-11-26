package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_14_LAST_GUEST_FOR_ROOM_AND_DATES;

@Slf4j
public class Item14Last3GuestForRoomAndDates implements MenuItem {

    private final String nameItem;

    public Item14Last3GuestForRoomAndDates() {
        this.nameItem = MENU_ITEM_14_LAST_GUEST_FOR_ROOM_AND_DATES;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
