package pl.senla.hotel.ui.main;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_MAIN;

@AppComponent
public class NavigatorMainMenu implements Navigator {

    public NavigatorMainMenu() {
    }

    public void buildMenu() {
        System.out.println(MENU_MAIN);
        MenuItem item1 = new Item1HotelFacilityOperations();
        MenuItem item2 = new Item2GuestOperations();
        MenuItem item3 = new Item3OrderOperations();
        MenuItem item4 = new Item4AnalyticsReports();
        MenuItem item5 = new Item5InputOutputData();
        MenuItem item0 = new Item0CloseApplication();
        MenuItem[] menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item0};
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
