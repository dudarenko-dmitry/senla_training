package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item19RoomInformation implements MenuItem {

    private final String nameItem;

    public Item19RoomInformation() {
        this.nameItem = "19. Show the details of a separate room (WHAT DOES IT MEAN???).";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
