package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_FACILITY;

@AppComponent
public class NavigatorHotelFacilities implements Navigator {

    private static NavigatorHotelFacilities navigatorHotelFacilities;
    private NavigatorHotelFacilities(){}
    private final String nameMenu = MENU_HOTEL_FACILITY;
    private final MenuItem item1 = new Item1RoomOperation();
    private final MenuItem item2 = new Item2TableOperation();
    private final MenuItem item3 = new Item3TransportOperation();
    private final MenuItem item0 = new Item0QuitToMain();
    private final MenuItem[] menuItems = {item1, item2, item3, item0};

    public static NavigatorHotelFacilities getSingletonInstance() {
        if (navigatorHotelFacilities == null) {
            navigatorHotelFacilities = new NavigatorHotelFacilities();
        }
        return navigatorHotelFacilities;
    }

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
