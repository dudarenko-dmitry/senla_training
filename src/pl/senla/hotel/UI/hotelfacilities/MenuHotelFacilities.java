package pl.senla.hotel.UI.hotelfacilities;

import pl.senla.hotel.UI.Menu;
import pl.senla.hotel.UI.MenuItem;

public class MenuHotelFacilities extends Menu {

    private String name = "\n===== Menu Hotel Facilities =====";
    private final MenuItem item1 = new HotelFasilitiesItem1();
    private final MenuItem item2 = new HotelFasilitiesItem2();
    private final MenuItem item3 = new HotelFasilitiesItem3();
    private final MenuItem item0 = new HotelFasilitiesItem0();
    private MenuItem[] menuItems = {item1, item2, item3, item0}; // TODO

    public MenuHotelFacilities(String nameMenu, MenuItem[] menuItems) {
        super(nameMenu, menuItems);
    }
}
