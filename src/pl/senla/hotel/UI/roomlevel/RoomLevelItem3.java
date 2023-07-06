package pl.senla.hotel.UI.roomlevel;

import pl.senla.hotel.UI.MenuItem;

public class RoomLevelItem3 implements MenuItem {

    private String nameItem;

    public RoomLevelItem3() {
        this.nameItem = "3. Lux 3***";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
