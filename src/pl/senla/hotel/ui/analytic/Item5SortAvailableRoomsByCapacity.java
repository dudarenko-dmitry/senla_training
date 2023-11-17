package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_SORT_AVAILABLE_ROOMS_BY_CAPACITY;

@Slf4j
public class Item5SortAvailableRoomsByCapacity implements MenuItem {

    private final String nameItem;

    public Item5SortAvailableRoomsByCapacity() {
        this.nameItem = MENU_ITEM_5_SORT_AVAILABLE_ROOMS_BY_CAPACITY;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
