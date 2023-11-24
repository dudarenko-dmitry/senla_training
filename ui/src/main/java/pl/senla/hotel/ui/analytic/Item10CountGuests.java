package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_10_COUNT_GUESTS;

@Slf4j
public class Item10CountGuests implements MenuItem {

    private final String nameItem;

    public Item10CountGuests() {
        this.nameItem = MENU_ITEM_10_COUNT_GUESTS;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
