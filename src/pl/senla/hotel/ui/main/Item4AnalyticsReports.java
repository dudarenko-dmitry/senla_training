package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_4_ANALYTICS_REPORTS;

public class Item4AnalyticsReports implements MenuItem {

    private final String nameItem;

    public Item4AnalyticsReports() {
        this.nameItem = MENU_ITEM_4_ANALYTICS_REPORTS;
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
