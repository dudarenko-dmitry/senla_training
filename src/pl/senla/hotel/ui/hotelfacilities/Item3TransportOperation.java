package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_3_TRANSPORT_OPERATION;

public class Item3TransportOperation implements MenuItem {

    private final String nameItem;

    public Item3TransportOperation() {
        nameItem = MENU_ITEM_3_TRANSPORT_OPERATION;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
