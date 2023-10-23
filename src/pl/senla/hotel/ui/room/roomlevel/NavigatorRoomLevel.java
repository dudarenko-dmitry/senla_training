package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_ROOM_LEVEL;

@AppComponent
public class NavigatorRoomLevel implements Navigator {

    public NavigatorRoomLevel() {
    }

    @Override
    public void buildMenu() {
        System.out.println(MENU_ROOM_LEVEL);
        MenuItem item1 = new Item1RoomEconomy();
        MenuItem item2 = new Item2RoomStandard();
        MenuItem item3 = new Item3RoomLux();
        MenuItem[] menuItems = {item1, item2, item3};
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
