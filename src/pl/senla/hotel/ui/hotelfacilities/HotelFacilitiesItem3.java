package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.MenuItem;

public class HotelFacilitiesItem3 implements MenuItem {

    private final String nameItem;

    public HotelFacilitiesItem3() {
        nameItem = "3. Transport operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
