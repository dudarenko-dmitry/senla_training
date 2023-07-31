package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorAnalytics implements Navigator {

    private static Navigator navigator;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorAnalytics() {
        this.nameMenu = "\n===== Menu Analytics Reports =====";
        MenuItem item1 = new AnalyticItem1();
        MenuItem item2 = new AnalyticItem2();
        MenuItem item3 = new AnalyticItem3();
        MenuItem item4  = new AnalyticItem4();
        MenuItem item5  = new AnalyticItem5();
        MenuItem item6  = new AnalyticItem6();
        MenuItem item7  = new AnalyticItem7();
        MenuItem item8  = new AnalyticItem8();
        MenuItem item9  = new AnalyticItem9();
        MenuItem item10 = new AnalyticItem10();
        MenuItem item11 = new AnalyticItem11();
        MenuItem item12 = new AnalyticItem12();
        MenuItem item13 = new AnalyticItem13();
        MenuItem item14 = new AnalyticItem14();
        MenuItem item15 = new AnalyticItem15();
        MenuItem item16 = new AnalyticItem16();
        MenuItem item17 = new AnalyticItem17();
        MenuItem item18 = new AnalyticItem18();
        MenuItem item19 = new AnalyticItem19();
        MenuItem item0  = new AnalyticItem0();
        this.menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item6,
                item7, item8, item9, item10, item11, item12, item13,
                item14, item15, item16, item17, item18, item19, item0};
    }

    public static Navigator getNavigatorAnalytics(){
        if (navigator == null) {
            navigator = new NavigatorAnalytics();
        }
        return navigator;
    }

    @Override
    public void buildMenu() {
        System.out.println(nameMenu);
        for (MenuItem i : menuItems){
            i.printItem();
        }
    }
}
