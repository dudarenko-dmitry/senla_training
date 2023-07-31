package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorGuest implements Navigator {

    private static Navigator navigator;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorGuest() {
        this.nameMenu = "\n===== Menu Guests =====";
        MenuItem item1 = new GuestItem1();
        MenuItem item2 = new GuestItem2();
        MenuItem item3 = new GuestItem3();
        MenuItem item4 = new GuestItem4();
        MenuItem item5 = new GuestItem5();
        MenuItem item0 = new GuestItem0();
        this.menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item0};
    }

    public static Navigator getNavigatorGuest(){
        if (navigator == null) {
            navigator = new NavigatorGuest();
        }
        return navigator;
    }

    public void buildMenu() {
        System.out.println(nameMenu);
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
