package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.MenuItem;

public class NavigatorHotelFacilities implements Navigator {

    private final String nameMenu = "\n===== Menu Hotel Facilities =====";
    private final MenuItem item1 = new HotelFacilitiesItem1();
    private final MenuItem item2 = new HotelFacilitiesItem2();
    private final MenuItem item3 = new HotelFacilitiesItem3();
    private final MenuItem item0 = new HotelFacilitiesItem0();
    private final MenuItem[] menuItems = {item1, item2, item3, item0};

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
