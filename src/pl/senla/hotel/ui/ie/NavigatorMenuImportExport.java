package pl.senla.hotel.ui.ie;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_INPUT_OUTPUT;

@AppComponent
public class NavigatorMenuImportExport implements Navigator {

    public NavigatorMenuImportExport() {
    }

    public void buildMenu() {
        System.out.println(MENU_INPUT_OUTPUT);
        MenuItem item1 = new Item1ImportAllData();
        MenuItem item2 = new Item2ExportAllData();
        MenuItem item3 = new Item3ImportRoomData();
        MenuItem item4 = new Item4ExportRoomData();
        MenuItem item5 = new Item5ImportGuestData();
        MenuItem item6 = new Item6ExportGuestData();
        MenuItem item7 = new Item7ImportServiceAndOrderData();
        MenuItem item8 = new Item8ExportServiceAndOrderData();
        MenuItem item0 = new Item0QuitToMain();
        MenuItem[] menuItems = new MenuItem[] {item1, item2, item3, item4, item5, item6, item7, item8, item0};
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
