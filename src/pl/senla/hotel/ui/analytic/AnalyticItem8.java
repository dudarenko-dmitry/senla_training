package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem8 implements MenuItem {

    private final String nameItem;

    public AnalyticItem8() {
        this.nameItem = "8. List of guests and their rooms sort by check-out date.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
