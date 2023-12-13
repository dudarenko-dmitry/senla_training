package pl.senla.hotel.ui.services;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOT_SERV;

@Component
@NoArgsConstructor
@Slf4j
public class NavigatorHotelServiceNew implements Navigator {

    @Override
    public void buildMenu() {
        log.info("");
        log.info(MENU_HOT_SERV);
        MenuItem item1 = new Item1ReadAllHotelServices();
        MenuItem item2 = new Item2ReadHotelService();
        MenuItem item3 = new Item3CreateHotelService();
        MenuItem item4 = new Item4UpdateHotelService();
        MenuItem item5 = new Item5DeleteHotelService();
        MenuItem item0 = new Item0QuitToMain();
        MenuItem[] menuItems = new MenuItem[]{item1, item2, item3, item4, item5, item0};
        for (MenuItem i : menuItems){
            i.printItem();
        }
    }
}
