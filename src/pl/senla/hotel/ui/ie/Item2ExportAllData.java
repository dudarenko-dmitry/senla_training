package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_2_EXPORT_ALL_DATA;

public class Item2ExportAllData implements MenuItem {

    private final String nameItem;

    public Item2ExportAllData() {
        this.nameItem = MENU_ITEM_2_EXPORT_ALL_DATA;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
