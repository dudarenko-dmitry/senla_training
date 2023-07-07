package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem2 implements MenuItem {

    private final String nameItem;

    public AnalyticItem2() {
        this.nameItem = "2. List of rooms by capacity.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
