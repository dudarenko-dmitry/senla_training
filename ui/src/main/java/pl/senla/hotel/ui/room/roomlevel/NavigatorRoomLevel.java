package pl.senla.hotel.ui.room.roomlevel;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_ROOM_LEVEL;

@Component
@NoArgsConstructor
@Slf4j
public class NavigatorRoomLevel implements Navigator {

    @Override
    public void buildMenu() {
        log.info("");
        log.info(MENU_ROOM_LEVEL);
        MenuItem item1 = new Item1RoomEconomy();
        MenuItem item2 = new Item2RoomStandard();
        MenuItem item3 = new Item3RoomLux();
        MenuItem[] menuItems = {item1, item2, item3};
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
