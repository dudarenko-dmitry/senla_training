package pl.senla.hotel.ui.order;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_DELETE_ORDER;

@Slf4j
public class Item5DeleteOrder implements MenuItem {

    private final String nameItem;

    public Item5DeleteOrder() {
        this.nameItem = MENU_ITEM_5_DELETE_ORDER;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
