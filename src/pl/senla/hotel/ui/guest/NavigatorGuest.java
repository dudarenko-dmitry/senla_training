package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorGuest implements Navigator {

    private final String nameMenu = "\n===== Menu Guests =====";
    private final MenuItem item1 = new GuestItem1();
    private final MenuItem item2 = new GuestItem2();
    private final MenuItem item3 = new GuestItem3();
    private final MenuItem item4 = new GuestItem4();
    private final MenuItem item5 = new GuestItem5();
    private final MenuItem item0 = new GuestItem0();
    private final MenuItem[] menuItems = {item1, item2, item3, item4, item5, item0};

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

    public MenuItem getItem4() {
        return item4;
    }

    public MenuItem getItem5() {
        return item5;
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
