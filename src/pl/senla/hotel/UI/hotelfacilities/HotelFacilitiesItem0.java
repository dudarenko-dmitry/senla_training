package pl.senla.hotel.UI.hotelfacilities;

import pl.senla.hotel.UI.Navigator;
import pl.senla.hotel.UI.MenuItem;

public class HotelFacilitiesItem0 implements MenuItem {

    private String nameItem;
    private Navigator nextNavigator; // TODO // what is it?

    public HotelFacilitiesItem0() {
        nameItem = "0. Quit to Main menu.";
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
