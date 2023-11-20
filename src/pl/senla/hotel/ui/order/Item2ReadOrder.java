package pl.senla.hotel.ui.order;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_READ_ORDER;

@Slf4j
public class Item2ReadOrder implements MenuItem {

    private final String nameItem;

    public Item2ReadOrder() {
        this.nameItem = MENU_ITEM_2_READ_ORDER;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
