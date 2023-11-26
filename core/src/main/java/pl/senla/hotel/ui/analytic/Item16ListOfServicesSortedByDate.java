package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_16_LIST_OF_SERVICES_SORTED_BY_DATE;

@Slf4j
public class Item16ListOfServicesSortedByDate implements MenuItem {

    private final String nameItem;

    public Item16ListOfServicesSortedByDate() {
        this.nameItem = MENU_ITEM_16_LIST_OF_SERVICES_SORTED_BY_DATE;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
