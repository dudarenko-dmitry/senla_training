package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem1 implements MenuItem {

    private final String nameItem;

    public AnalyticItem1() {
        this.nameItem = "1. List of rooms sort by price.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
