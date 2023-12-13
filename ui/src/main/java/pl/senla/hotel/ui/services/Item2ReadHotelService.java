package pl.senla.hotel.ui.services;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_READ_HOT_SERV;

@Slf4j
public class Item2ReadHotelService implements MenuItem {

    private final String nameItem;

    public Item2ReadHotelService() {
        this.nameItem = MENU_ITEM_2_READ_HOT_SERV;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
