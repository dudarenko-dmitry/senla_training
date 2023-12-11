package pl.senla.hotel.ui.guest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_GUEST;

@Component
@Qualifier("NavigatorGuest")
@NoArgsConstructor
@Slf4j
public class NavigatorGuest implements Navigator {

    public void buildMenu() {
        log.info("");
        log.info(MENU_GUEST);
        MenuItem item1 = new Item1ReadAllGuests();
        MenuItem item2 = new Item2ReadGuest();
        MenuItem item3 = new Item3CreateGuest();
        MenuItem item4 = new Item4UpdateGuest();
        MenuItem item5 = new Item5DeleteGuest();
        MenuItem item0 = new Item0QuitToMain();
        MenuItem[] menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item0};
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
