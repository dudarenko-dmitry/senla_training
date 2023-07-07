package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem14 implements MenuItem {

    private final String nameItem;

    public AnalyticItem14() {
        this.nameItem = "14. View the last 3 guests of the room and the dates of their stay.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
