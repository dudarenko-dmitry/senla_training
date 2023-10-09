package pl.senla.hotel.ui.guest;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_GUEST;

@AppComponent
public class NavigatorGuest implements Navigator {

    private static Navigator navigator;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorGuest() {
        this.nameMenu = MENU_GUEST;
        MenuItem item1 = new Item1ReadAllGuests();
        MenuItem item2 = new Item2ReadGuest();
        MenuItem item3 = new Item3CreateGuest();
        MenuItem item4 = new Item4UpdateGuest();
        MenuItem item5 = new Item5DeleteGuest();
        MenuItem item0 = new Item0QuitToMain();
        this.menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item0};
    }

    public static Navigator getSingletonInstance(){
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
