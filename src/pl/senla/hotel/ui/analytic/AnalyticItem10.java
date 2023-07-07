package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem10 implements MenuItem {

    private final String nameItem;

    public AnalyticItem10() {
        this.nameItem = "10. Total number of guests.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
