package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorAnalytics implements Navigator {

    private final String nameMenu = "\n===== Menu Analytics Reports =====";
    private final MenuItem[] menuItems;

    public NavigatorAnalytics() {
        MenuItem item1 = new AnalyticItem1();
        MenuItem item2 = new AnalyticItem1();
        MenuItem item3 = new AnalyticItem1();
        MenuItem item4  = new AnalyticItem1();
        MenuItem item5  = new AnalyticItem1();
        MenuItem item6  = new AnalyticItem1();
        MenuItem item7  = new AnalyticItem1();
        MenuItem item8  = new AnalyticItem1();
        MenuItem item9  = new AnalyticItem1();
        MenuItem item10 = new AnalyticItem1();
        MenuItem item11 = new AnalyticItem1();
        MenuItem item12 = new AnalyticItem1();
        MenuItem item13 = new AnalyticItem1();
        MenuItem item14 = new AnalyticItem1();
        MenuItem item15 = new AnalyticItem1();
        MenuItem item16 = new AnalyticItem1();
        MenuItem item17 = new AnalyticItem1();
        MenuItem item18 = new AnalyticItem1();
        MenuItem item19 = new AnalyticItem1();
        MenuItem item0  = new AnalyticItem1();
        this.menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item6,
                item7, item8, item9, item10, item11, item12, item13,
                item14, item15, item16, item17, item18, item19, item0};
    }

    @Override
    public void buildMenu() {
        System.out.println(nameMenu);
        for (MenuItem i : menuItems){
            i.printItem();
        }
    }
}
