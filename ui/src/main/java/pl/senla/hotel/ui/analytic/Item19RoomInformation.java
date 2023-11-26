package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_19_ROOM_INFORMATION;

@Slf4j
public class Item19RoomInformation implements MenuItem {

    private final String nameItem;

    public Item19RoomInformation() {
        this.nameItem = MENU_ITEM_19_ROOM_INFORMATION;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
