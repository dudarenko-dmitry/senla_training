package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_SORT_ROOMS_BY_LEVEL;

@Slf4j
public class Item3SortRoomsByLevel implements MenuItem {

    private final String nameItem;

    public Item3SortRoomsByLevel() {
        this.nameItem = MENU_ITEM_3_SORT_ROOMS_BY_LEVEL;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
