package pl.senla.hotel.ui.main;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_ITEM_5_ANALYTICS_REPORTS;

@Slf4j
public class Item5AnalyticsReports implements MenuItem {

    private final String nameItem;

    public Item5AnalyticsReports() {
        this.nameItem = MENU_ITEM_5_ANALYTICS_REPORTS;
    }

    @Override
    public void printItem() {
        log.info(nameItem);
    }
}
