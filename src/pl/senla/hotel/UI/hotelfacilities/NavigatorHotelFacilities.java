package pl.senla.hotel.UI.hotelfacilities;

import pl.senla.hotel.UI.Navigator;
import pl.senla.hotel.UI.MenuItem;

public class NavigatorHotelFacilities implements Navigator {

    protected String nameMenu = "\n===== Menu Hotel Facilities =====";
    protected MenuItem item1 = new HotelFacilitiesItem1();
    protected MenuItem item2 = new HotelFacilitiesItem2();
    protected MenuItem item3 = new HotelFacilitiesItem3();
    protected MenuItem item0 = new HotelFacilitiesItem0();
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
