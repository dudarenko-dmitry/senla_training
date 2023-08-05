package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorMenuImportExport implements Navigator {

    private static Navigator navigator;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorMenuImportExport() {
        this.nameMenu = "\n<<<<< Data's Import-Export >>>>>";
        MenuItem item1 = new ImportExportMenuItem1();
        MenuItem item2 = new ImportExportMenuItem2();
        MenuItem item3 = new ImportExportMenuItem3();
        MenuItem item4 = new ImportExportMenuItem4();
        MenuItem item5 = new ImportExportMenuItem5();
        MenuItem item6 = new ImportExportMenuItem6();
        MenuItem item7 = new ImportExportMenuItem7();
        MenuItem item8 = new ImportExportMenuItem8();
        MenuItem item0 = new ImportExportMenuItem0();
        this.menuItems = new MenuItem[] {item1, item2, item3, item4, item5, item6, item7, item8, item0};
    }

    public static Navigator getNavigator() {
        if (navigator == null) {
            navigator = new NavigatorMenuImportExport();
        }
        return navigator;
    }

    public void buildMenu() {
        System.out.println(nameMenu);
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
