package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem9 implements MenuItem {

    private final String nameItem;

    public AnalyticItem9() {
        this.nameItem = "9. Total number of available rooms.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
