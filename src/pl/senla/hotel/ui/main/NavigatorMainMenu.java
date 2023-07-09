package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorMainMenu implements Navigator {

    private final String nameMenu = "\n<<<<< Welcome to Hotel >>>>>";
    private final MenuItem item1 = new MainMenuItem1();
    private final MenuItem item2 = new MainMenuItem2();
    private final MenuItem item3 = new MainMenuItem3();
    private final MenuItem item4 = new MainMenuItem4();
    private final MenuItem item0 = new MainMenuItem0();
    private final MenuItem[] menuItems = {item1, item2, item3, item4, item0};

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
