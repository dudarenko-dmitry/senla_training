package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem11 implements MenuItem {

    private final String nameItem;

    public AnalyticItem11() {
        this.nameItem = "11. Total number of guests on date.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
