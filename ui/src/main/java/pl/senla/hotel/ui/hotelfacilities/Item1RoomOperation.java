package pl.senla.hotel.ui.hotelfacilities;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_ROOM_OPERATION;

@Slf4j
public class Item1RoomOperation implements MenuItem {

    private final String nameItem;

    public Item1RoomOperation() {
        nameItem = MENU_ITEM_1_ROOM_OPERATION;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
