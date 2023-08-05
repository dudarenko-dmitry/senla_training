package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorMainMenu implements Navigator {

    private static Navigator navigator;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorMainMenu() {
        this.nameMenu = "\n<<<<< Welcome to Hotel >>>>>";
        MenuItem item1 = new MainMenuItem1();
        MenuItem item2 = new MainMenuItem2();
        MenuItem item3 = new MainMenuItem3();
        MenuItem item4 = new MainMenuItem4();
        MenuItem item5 = new MainMenuItem5();
        MenuItem item0 = new MainMenuItem0();
        this.menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item0};
    }

    public static Navigator getNavigator() {
        if (navigator == null) {
            navigator = new NavigatorMainMenu();
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
