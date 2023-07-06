package pl.senla.hotel.UI.main;

import pl.senla.hotel.UI.MenuItem;
import pl.senla.hotel.UI.Navigator;
import pl.senla.hotel.UI.room.*;

public class NavigatorMainMenu implements Navigator {

    protected String nameMenu = "\n<<<<< Welcome to Hotel >>>>>";
    protected MenuItem item1 = new MainMenuItem1();
    protected MenuItem item2 = new MainMenuItem2();
    protected MenuItem item3 = new MainMenuItem3();
    protected MenuItem item4 = new MainMenuItem4();
    protected MenuItem item0 = new MainMenuItem0();
    protected MenuItem[] menuItems = {item1, item2, item3, item3, item4, item0};

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
