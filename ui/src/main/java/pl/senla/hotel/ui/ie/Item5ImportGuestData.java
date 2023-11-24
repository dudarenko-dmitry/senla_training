package pl.senla.hotel.ui.ie;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_IMPORT_GUEST_DATA;

@Slf4j
public class Item5ImportGuestData implements MenuItem {

    private final String nameItem;

    public Item5ImportGuestData() {
        this.nameItem = MENU_ITEM_5_IMPORT_GUEST_DATA;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
