package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.Item0QuitToMain;

import static pl.senla.hotel.constant.MenuConstant.MENU_ORDER;

public class NavigatorOrder implements Navigator {

    private static Navigator navigator;
    private final MenuItem[] menuItems;

    private NavigatorOrder() {
        MenuItem item1 = new Item1ReadAllOrders();
        MenuItem item2 = new Item2ReadOrder();
        MenuItem item3 = new Item3CreateOrder();
        MenuItem item4 = new Item4UpdateOrder();
        MenuItem item5 = new Item5DeleteOrder();
        MenuItem item0 = new Item0QuitToMain();
        this.menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item0};
    }

    public static Navigator getNavigatorOrder(){
        if (navigator == null) {
            navigator = new NavigatorOrder();
        }
        return navigator;
    }

    @Override
    public void buildMenu() {
        System.out.println(MENU_ORDER);
        for (MenuItem i : menuItems){
            i.printItem();
        }
    }
}
