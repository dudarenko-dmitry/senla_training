package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class AnalyticItem13 implements MenuItem {

    private final String nameItem;

    public AnalyticItem13() {
        this.nameItem = "13. The amount of payment for the room to be paid by the guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
