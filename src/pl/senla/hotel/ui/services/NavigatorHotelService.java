package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorHotelService implements Navigator {

    private final String nameMenu;
    private final MenuItem[] menuItems;

    public NavigatorHotelService() {
        this.nameMenu = "\n===== Hotel Services =====";
        MenuItem item1 = new HotelServiceItem1();
        MenuItem item2 = new HotelServiceItem2();
        MenuItem item3 = new HotelServiceItem3();
        MenuItem item0 = new HotelServiceItem0();
        this.menuItems = new MenuItem[]{item1, item2, item3, item0};
    }

    @Override
    public void buildMenu() {
        System.out.println(nameMenu);
        for(MenuItem i : menuItems){
            i.printItem();
        }
    }
}
