package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorHotelService implements Navigator {

    private static Navigator navigatorHotelService;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorHotelService() {
        this.nameMenu = "\n===== Hotel Services =====";
        MenuItem item1 = new HotelServiceItem1();
        MenuItem item2 = new HotelServiceItem2();
        MenuItem item3 = new HotelServiceItem3();
        MenuItem item0 = new HotelServiceItem0();
        this.menuItems = new MenuItem[]{item1, item2, item3, item0};
    }

    public static Navigator getNavigatorHotelService() {
        if (navigatorHotelService == null) {
            navigatorHotelService = new NavigatorHotelService();
        }
        return navigatorHotelService;
    }

    @Override
    public void buildMenu() {
        System.out.println(nameMenu);
        for(MenuItem i : menuItems){
            i.printItem();
        }
    }
}
