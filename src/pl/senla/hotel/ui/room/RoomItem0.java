package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class RoomItem0 implements MenuItem {

    private final String nameItem;

    public RoomItem0() {
        this.nameItem = "0. Quit to Main menu.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
