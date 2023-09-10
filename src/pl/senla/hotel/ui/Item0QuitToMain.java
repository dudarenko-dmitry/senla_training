package pl.senla.hotel.ui;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_0_QUIT_TO_MAIN;

public class Item0QuitToMain implements MenuItem {

    private final String nameItem;

    public Item0QuitToMain() {
        this.nameItem = MENU_ITEM_0_QUIT_TO_MAIN;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
