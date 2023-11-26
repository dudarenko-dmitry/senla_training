package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_18_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_PRICE;

@Slf4j
public class Item18ListOfServicesAndRoomsSortByPrice implements MenuItem {

    private final String nameItem;

    public Item18ListOfServicesAndRoomsSortByPrice() {
        this.nameItem = MENU_ITEM_18_LIST_OF_SERVICES_AND_ROOMS_SORT_BY_PRICE;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
