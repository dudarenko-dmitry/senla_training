package pl.senla.hotel.ui.room.roomlevel;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ROOM_2;

@Slf4j
public class Item2RoomStandard implements MenuItem {

    private final String nameItem;

    public Item2RoomStandard() {
        this.nameItem = MENU_ROOM_2;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
