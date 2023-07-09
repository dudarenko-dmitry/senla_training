package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem6 implements MenuItem {

    private final String nameItem;

    public AnalyticItem6() {
        this.nameItem = "6. List of available rooms sort by number of stars.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
