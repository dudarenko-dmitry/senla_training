package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_6_EXPORT_GUEST_DATA;

public class Item6ExportGuestData implements MenuItem {

    private final String nameItem;

    public Item6ExportGuestData() {
        this.nameItem = MENU_ITEM_6_EXPORT_GUEST_DATA;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
