package pl.senla.hotel.ui.main;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_4_HOT_SERV_OPERATIONS;

@Slf4j
public class Item4HotelServicesOperations implements MenuItem {

    private final String nameItem;

    public Item4HotelServicesOperations() {
        this.nameItem = MENU_ITEM_4_HOT_SERV_OPERATIONS;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
