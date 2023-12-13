package pl.senla.hotel.ui.services;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_READ_ALL_HOT_SERV;

@Slf4j
public class Item1ReadAllHotelServices implements MenuItem {

    private final String nameItem;

    public Item1ReadAllHotelServices() {
        this.nameItem = MENU_ITEM_1_READ_ALL_HOT_SERV;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}