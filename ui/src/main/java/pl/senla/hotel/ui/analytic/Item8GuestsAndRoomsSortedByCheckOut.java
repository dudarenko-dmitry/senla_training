package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_8_GUESTS_AND_ROOMS_SORTED_BY_CHECK_OUT;

@Slf4j
public class Item8GuestsAndRoomsSortedByCheckOut implements MenuItem {

    private final String nameItem;

    public Item8GuestsAndRoomsSortedByCheckOut() {
        this.nameItem = MENU_ITEM_8_GUESTS_AND_ROOMS_SORTED_BY_CHECK_OUT;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
