package pl.senla.hotel.ui.room;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_6_UPDATE_ROOM_REPAIRED;

@Slf4j
public class Item6UpdateRoomRepaired implements MenuItem {

    private final String nameItem;

    public Item6UpdateRoomRepaired() {
        this.nameItem = MENU_ITEM_6_UPDATE_ROOM_REPAIRED;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
