package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_1_READ_ALL_GUESTS;

public class Item1ReadAllGuests implements MenuItem {

    private final String nameItem;

    public Item1ReadAllGuests() {
        this.nameItem = MENU_ITEM_1_READ_ALL_GUESTS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
