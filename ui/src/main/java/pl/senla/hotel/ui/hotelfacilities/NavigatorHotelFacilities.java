package pl.senla.hotel.ui.hotelfacilities;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.MenuItem;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_FACILITY;

@Component
@NoArgsConstructor
@Slf4j
public class NavigatorHotelFacilities implements Navigator {

    public void buildMenu() {
        log.info("");
        log.info(MENU_HOTEL_FACILITY);
        MenuItem item1 = new Item1RoomOperation();
        MenuItem item2 = new Item2TableOperation();
        MenuItem item3 = new Item3TransportOperation();
        MenuItem item0 = new Item0QuitToMain();
        MenuItem[] menuItems = new MenuItem[] {item1, item2, item3, item0};
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
