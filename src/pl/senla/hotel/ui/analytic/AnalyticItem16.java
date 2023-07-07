package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem16 implements MenuItem {

    private final String nameItem;

    public AnalyticItem16() {
        this.nameItem = "16. View the list of guest services and their price sort by date.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
