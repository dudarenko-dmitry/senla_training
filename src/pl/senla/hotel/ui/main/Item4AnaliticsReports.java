package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class Item4AnaliticsReports implements MenuItem {

    private final String nameItem;

    public Item4AnaliticsReports() {
        this.nameItem = "4. Analytics reports.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
