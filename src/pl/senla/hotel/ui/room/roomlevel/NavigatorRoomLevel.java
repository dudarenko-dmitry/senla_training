package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorRoomLevel implements Navigator {

    protected String nameMenu = "\n Rooms' levels: ";
    protected MenuItem item1 = new RoomLevelItem1();
    protected MenuItem item2 = new RoomLevelItem2();
    protected MenuItem item3 = new RoomLevelItem3();
    protected MenuItem[] menuItems = {item1, item2, item3};

    @Override
    public void buildMenu() {
        System.out.println(nameMenu);
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
