package pl.senla.hotel.ui.main;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_ORDER_OPERATIONS;

@Slf4j
public class Item3OrderOperations implements MenuItem {

    private final String nameItem;

    public Item3OrderOperations() {
        this.nameItem = MENU_ITEM_3_ORDER_OPERATIONS;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
