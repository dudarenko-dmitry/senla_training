package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_IMPORT_ALL_DATA;

public class Item1ImportAllData implements MenuItem {

    private final String nameItem;

    public Item1ImportAllData() {
        this.nameItem = MENU_ITEM_1_IMPORT_ALL_DATA;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
