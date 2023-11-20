package pl.senla.hotel.ui.services;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.MenuConstant.MENU_HOTEL_SERVICE;

@AppComponent
@Slf4j
public class NavigatorHotelService implements Navigator {

    public NavigatorHotelService() {
    }

    @Override
    public void buildMenu() {
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
