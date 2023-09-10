package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_8_EXPORT_SERVICE_AND_ORDER_DATA;

public class Item8ExportServiceAndOrderData implements MenuItem {

    private final String nameItem;

    public Item8ExportServiceAndOrderData() {
        this.nameItem = MENU_ITEM_8_EXPORT_SERVICE_AND_ORDER_DATA;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
