package pl.senla.hotel.ui.guest;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_4_UPDATE_GUEST;

@Slf4j
public class Item4UpdateGuest implements MenuItem {

    private final String nameItem;

    public Item4UpdateGuest() {
        this.nameItem = MENU_ITEM_4_UPDATE_GUEST;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
