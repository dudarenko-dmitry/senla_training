package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.MenuItem;

public class HotelFacilitiesItem1 implements MenuItem {

    private String nameItem;
    private Navigator nextNavigator; // TODO // what is it?

    public HotelFacilitiesItem1() {
        nameItem = "1. Room operations.";
        nextNavigator = null;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Navigator getNextMenu() {
        return nextNavigator;
    }

    public void setNextMenu(Navigator nextNavigator) {
        this.nextNavigator = nextNavigator;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
