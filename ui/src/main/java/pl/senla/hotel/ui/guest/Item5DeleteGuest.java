package pl.senla.hotel.ui.guest;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_DELETE_GUEST;

@Slf4j
public class Item5DeleteGuest implements MenuItem {

    private final String nameItem;

    public Item5DeleteGuest() {
        this.nameItem = MENU_ITEM_5_DELETE_GUEST;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
