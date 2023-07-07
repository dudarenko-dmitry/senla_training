package pl.senla.hotel.ui.roomlevel;

import pl.senla.hotel.ui.MenuItem;

public class RoomLevelItem3 implements MenuItem {

    private final String nameItem;

    public RoomLevelItem3() {
        this.nameItem = "3. Lux 3***";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
