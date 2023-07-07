package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem5 implements MenuItem {

    private final String nameItem;

    public AnalyticItem5() {
        this.nameItem = "5. List of available rooms sort by capacity.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
