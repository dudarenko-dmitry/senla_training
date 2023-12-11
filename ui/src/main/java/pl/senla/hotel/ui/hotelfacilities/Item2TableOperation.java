package pl.senla.hotel.ui.hotelfacilities;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_TABLE_OPERATION;

@Slf4j
public class Item2TableOperation implements MenuItem {

    private final String nameItem;

    public Item2TableOperation() {
        nameItem = MENU_ITEM_2_TABLE_OPERATION;
    }

    @Override
    public void printItem() {
        log.warn(nameItem);
    }
}
