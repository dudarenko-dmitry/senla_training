package pl.senla.hotel.ui.hotelfacilities;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_TRANSPORT_OPERATION;

@Slf4j
public class Item3TransportOperation implements MenuItem {

    private final String nameItem;

    public Item3TransportOperation() {
        nameItem = MENU_ITEM_3_TRANSPORT_OPERATION;
    }

    @Override
    public void printItem() {
        log.warn(nameItem);
    }
}
