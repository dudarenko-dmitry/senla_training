package pl.senla.hotel.ui.services;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_SERVICE;

@Component
@Qualifier("NavigatorHotelService")
@NoArgsConstructor
@Slf4j
public class NavigatorHotelService implements Navigator {

    @Override
    public void buildMenu() {
        log.info("");
        log.info(MENU_HOTEL_SERVICE);
        MenuItem item1 = new Item1RoomReservation();
        MenuItem item2 = new Item2RestaurantReservation();
        MenuItem item3 = new Item3TransferReservation();
        MenuItem item0 = new Item0QuitToOrderMenu();
        MenuItem[] menuItems = new MenuItem[]{item1, item2, item3, item0};
        for(MenuItem i : menuItems){
            i.printItem();
        }
    }
}
