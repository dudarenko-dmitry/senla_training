package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_ROOM_LEVEL;

public class NavigatorRoomLevel implements Navigator {

    protected String nameMenu = MENU_ROOM_LEVEL;
    protected MenuItem item1 = new Item1RoomEconomy();
    protected MenuItem item2 = new Item2RoomStandard();
    protected MenuItem item3 = new Item3RoomLux();
    protected MenuItem[] menuItems = {item1, item2, item3};

    @Override
    public void buildMenu() {
        System.out.println(nameMenu);
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
