package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_12_AVAILABLE_ROOMS_ON_DATE;

@Slf4j
public class Item12AvailableRoomsOnDate implements MenuItem {

    private final String nameItem;

    public Item12AvailableRoomsOnDate() {
        this.nameItem = MENU_ITEM_12_AVAILABLE_ROOMS_ON_DATE;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
