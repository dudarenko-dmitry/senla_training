package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem0 implements MenuItem {

    private final String nameItem;

    public AnalyticItem0() {
        this.nameItem = "0. Quit to Main menu.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
