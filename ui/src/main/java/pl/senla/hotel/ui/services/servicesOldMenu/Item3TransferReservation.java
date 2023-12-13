package pl.senla.hotel.ui.services.servicesOldMenu;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_TRANSFER_RESERVATION;

@Slf4j
public class Item3TransferReservation implements MenuItem {

    private final String nameItem;

    public Item3TransferReservation() {
        this.nameItem = MENU_ITEM_3_TRANSFER_RESERVATION;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}