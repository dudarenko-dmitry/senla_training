package pl.senla.hotel.ui.guest;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_CREATE_GUEST;

@Slf4j
public class Item3CreateGuest implements MenuItem {

    private final String nameItem;

    public Item3CreateGuest() {
        this.nameItem = MENU_ITEM_3_CREATE_GUEST;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
