package pl.senla.hotel.ui.guest;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_READ_GUEST;

@Slf4j
public class Item2ReadGuest implements MenuItem {

    private final String nameItem;

    public Item2ReadGuest() {
        this.nameItem = MENU_ITEM_2_READ_GUEST;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
