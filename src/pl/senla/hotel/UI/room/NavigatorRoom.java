package pl.senla.hotel.UI.room;

import pl.senla.hotel.UI.MenuItem;
import pl.senla.hotel.UI.Navigator;
import pl.senla.hotel.UI.hotelfacilities.HotelFacilitiesItem0;
import pl.senla.hotel.UI.hotelfacilities.HotelFacilitiesItem1;
import pl.senla.hotel.UI.hotelfacilities.HotelFacilitiesItem2;
import pl.senla.hotel.UI.hotelfacilities.HotelFacilitiesItem3;
import pl.senla.hotel.entity.facilities.Room;

public class NavigatorRoom implements Navigator {

    protected String nameMenu = "\n===== Menu Rooms =====";
    protected MenuItem item1 = new RoomItem1();
    protected MenuItem item2 = new RoomItem2();
    protected MenuItem item3 = new RoomItem3();
    protected MenuItem item4 = new RoomItem4();
    protected MenuItem item5 = new RoomItem5();
    protected MenuItem item0 = new RoomItem0();
    protected MenuItem[] menuItems = {item1, item2, item3, item0};

    public String getNameMenu() {
        return nameMenu;
    }

    public MenuItem getItem1() {
        return item1;
    }

    public MenuItem getItem2() {
        return item2;
    }

    public MenuItem getItem3() {
        return item3;
    }

    public MenuItem getItem0() {
        return item0;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public void buildMenu() {
        System.out.println(nameMenu);
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
