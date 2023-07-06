package pl.senla.hotel.UI.room;

import pl.senla.hotel.UI.MenuItem;

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
