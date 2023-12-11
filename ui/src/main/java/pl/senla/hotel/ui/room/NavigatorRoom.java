package pl.senla.hotel.ui.room;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_ROOM;

@Component
@NoArgsConstructor
@Slf4j
public class NavigatorRoom implements Navigator {

    public void buildMenu() {
        log.info("");
        log.info(MENU_ROOM);
        MenuItem item1 = new Item1ReadAllRooms();
        MenuItem item2 = new Item2ReadRoom();
        MenuItem item3 = new Item3CreateRoom();
        MenuItem item4 = new Item4UpdateRoom();
        MenuItem item5 = new Item5UpdateRoomAvailable();
        MenuItem item6 = new Item6UpdateRoomRepaired();
        MenuItem item7 = new Item7DeleteRoom();
        MenuItem item0 = new Item0QuitToMain();
        MenuItem[] menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item6, item7, item0};
        for (MenuItem i : menuItems) {
            i.printItem();
        }
    }
}
