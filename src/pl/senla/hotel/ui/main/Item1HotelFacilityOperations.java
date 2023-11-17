package pl.senla.hotel.ui.main;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_HOTEL_FACILITY_OPERATIONS;

@Slf4j
public class Item1HotelFacilityOperations implements MenuItem {

    private final String nameItem;

    public Item1HotelFacilityOperations() {
        this.nameItem = MENU_ITEM_1_HOTEL_FACILITY_OPERATIONS;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
