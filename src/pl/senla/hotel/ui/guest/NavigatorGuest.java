package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorGuest implements Navigator {

    private static Navigator navigator;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorGuest() {
        this.nameMenu = "\n===== Menu Guests =====";
        MenuItem item1 = new Item1ReadAllGuests();
        MenuItem item2 = new Item2ReadGuest();
        MenuItem item3 = new Item3CreateGuest();
        MenuItem item4 = new Item4UpdateGuest();
        MenuItem item5 = new Item5DeleteGuest();
        MenuItem item0 = new Item0QuitToMain();
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
