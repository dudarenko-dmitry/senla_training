package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_ROOM;

public class NavigatorRoom implements Navigator {

    private static Navigator navigatorRoom;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorRoom() {
        this.nameMenu = MENU_ROOM;
        MenuItem item1 = new Item1ReadAllRooms();
        MenuItem item2 = new Item2ReadRoom();
        MenuItem item3 = new Item3CreateRoom();
        MenuItem item4 = new Item4UpdateRoom();
        MenuItem item5 = new Item5UpdateRoomAvailable();
        MenuItem item6 = new Item6UpdateRoomRepaired();
        MenuItem item7 = new Item7DeleteRoom();
        MenuItem item0 = new Item0QuitToMain();
        this.menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item6, item7, item0};
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
