package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem15 implements MenuItem {

    private final String nameItem;

    public AnalyticItem15() {
        this.nameItem = "15. View the list of guest services and their price sort by price.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
