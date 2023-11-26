package pl.senla.hotel.ui.order;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_4_UPDATE_ORDER;

@Slf4j
public class Item4UpdateOrder implements MenuItem {

    private final String nameItem;

    public Item4UpdateOrder() {
        this.nameItem = MENU_ITEM_4_UPDATE_ORDER;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
