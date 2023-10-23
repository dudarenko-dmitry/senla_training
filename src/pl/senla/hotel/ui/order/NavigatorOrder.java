package pl.senla.hotel.ui.order;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.Item0QuitToMain;

import static pl.senla.hotel.constant.MenuConstant.MENU_ORDER;

@AppComponent
public class NavigatorOrder implements Navigator {

    public NavigatorOrder() {
    }

    @Override
    public void buildMenu() {
        System.out.println(MENU_ORDER);
        MenuItem item1 = new Item1ReadAllOrders();
        MenuItem item2 = new Item2ReadOrder();
        MenuItem item3 = new Item3CreateOrder();
        MenuItem item4 = new Item4UpdateOrder();
        MenuItem item5 = new Item5DeleteOrder();
        MenuItem item0 = new Item0QuitToMain();
        MenuItem[] menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item0};
        for (MenuItem i : menuItems){
            i.printItem();
        }
    }
}
