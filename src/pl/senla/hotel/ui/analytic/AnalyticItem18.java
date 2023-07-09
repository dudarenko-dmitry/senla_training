package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem18 implements MenuItem {

    private final String nameItem;

    public AnalyticItem18() {
        this.nameItem = "18. Prices of services and rooms sort by price.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
