package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorRoom implements Navigator {

    private static Navigator navigatorRoom;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorRoom() {
        this.nameMenu = "\n===== Menu Rooms =====";
        MenuItem item1 = new RoomItem1();
        MenuItem item2 = new RoomItem2();
        MenuItem item3 = new RoomItem3();
        MenuItem item4 = new RoomItem4();
        MenuItem item5 = new RoomItem5();
        MenuItem item0 = new RoomItem0();
        this.menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item0};
    }

    public static Navigator getNavigatorRoom(){
        if (navigatorRoom == null) {
            navigatorRoom = new NavigatorRoom();
        }
        return navigatorRoom;
    }

    public void buildMenu() {
        System.out.println(nameMenu);
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
