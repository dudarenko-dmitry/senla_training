package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class Item7ImportServiceAndOrderData implements MenuItem {

    private final String nameItem;

    public Item7ImportServiceAndOrderData() {
        this.nameItem = "7. Import (load) Orders' and Services' information from file.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
