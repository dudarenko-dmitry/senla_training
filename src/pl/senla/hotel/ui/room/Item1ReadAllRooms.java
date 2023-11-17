package pl.senla.hotel.ui.room;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_READ_ALL_ROOMS;

@Slf4j
public class Item1ReadAllRooms implements MenuItem {

    private final String nameItem;

    public Item1ReadAllRooms() {
        this.nameItem = MENU_ITEM_1_READ_ALL_ROOMS;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
