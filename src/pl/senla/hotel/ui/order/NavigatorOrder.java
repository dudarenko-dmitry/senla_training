package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorOrder implements Navigator {

    private static Navigator navigator;
    private final String menuName = "\n===== Menu Orders =====";
    private final MenuItem[] menuItems;

    private NavigatorOrder() {
        MenuItem item1 = new OrderItem1();
        MenuItem item2 = new OrderItem2();
        MenuItem item3 = new OrderItem3();
        MenuItem item4 = new OrderItem4();
        MenuItem item5 = new OrderItem5();
        MenuItem item0 = new OrderItem0();
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
        System.out.println(menuName);
        for (MenuItem i : menuItems){
            i.printItem();
        }
    }
}
