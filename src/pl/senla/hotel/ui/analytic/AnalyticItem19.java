package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem19 implements MenuItem {

    private final String nameItem;

    public AnalyticItem19() {
        this.nameItem = "19. Show the details of a separate room (WHAT DOES IT MEAN???).";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
