package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_11_COUNT_GUESTS_ON_DATE;

@Slf4j
public class Item11CountGuestsOnDate implements MenuItem {

    private final String nameItem;

    public Item11CountGuestsOnDate() {
        this.nameItem = MENU_ITEM_11_COUNT_GUESTS_ON_DATE;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
