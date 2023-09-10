package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_INPUT_OUTPUT;

public class Item5InputOutputData implements MenuItem {

    private final String nameItem;

    public Item5InputOutputData() {
        this.nameItem = MENU_ITEM_5_INPUT_OUTPUT;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
