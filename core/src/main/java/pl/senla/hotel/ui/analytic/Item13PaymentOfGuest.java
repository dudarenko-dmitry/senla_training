package pl.senla.hotel.ui.analytic;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_13_PAYMENT_OF_GUEST;

@Slf4j
public class Item13PaymentOfGuest implements MenuItem {

    private final String nameItem;

    public Item13PaymentOfGuest() {
        this.nameItem = MENU_ITEM_13_PAYMENT_OF_GUEST;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
