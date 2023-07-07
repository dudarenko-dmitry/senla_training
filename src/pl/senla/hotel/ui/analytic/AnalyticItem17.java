package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem17 implements MenuItem {

    private final String nameItem;

    public AnalyticItem17() {
        this.nameItem = "17. Prices of services and rooms sort by category.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
