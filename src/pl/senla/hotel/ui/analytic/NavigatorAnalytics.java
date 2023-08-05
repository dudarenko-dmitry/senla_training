package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.Item0QuitToMain;
import pl.senla.hotel.ui.MenuItem;
import pl.senla.hotel.ui.Navigator;

public class NavigatorAnalytics implements Navigator {

    private static Navigator navigator;
    private final String nameMenu;
    private final MenuItem[] menuItems;

    private NavigatorAnalytics() {
        this.nameMenu = "\n===== Menu Analytics Reports =====";
        MenuItem item1 = new Item1SortRoomsByPrice();
        MenuItem item2 = new Item2SortRoomsByCapacity();
        MenuItem item3 = new Item3SortRoomsByLevel();
        MenuItem item4  = new Item4SortAvailableRoomsByPrice();
        MenuItem item5  = new Item5SortAvailableRoomsByCapacity();
        MenuItem item6  = new Item6SortAvailableRoomsByLevel();
        MenuItem item7  = new Item7GuestsSortedByNameAndRooms();
        MenuItem item8  = new Item8GuestsAndRoomsSortedByCheckOut();
        MenuItem item9  = new Item9CountAvailableRooms();
        MenuItem item10 = new Item10CountGuests();
        MenuItem item11 = new Item11CountGuestsOnDate();
        MenuItem item12 = new Item12AvailableRoomsOnDate();
        MenuItem item13 = new Item13PaimentOfGuest();
        MenuItem item14 = new Item14Last3GuestForRoomAndDates();
        MenuItem item15 = new Item15ListOfServicesSortedByPrice();
        MenuItem item16 = new Item16ListOfServicesSortedByDate();
        MenuItem item17 = new Item17Item15ListOfServicesAndRoomsSortByCategory();
        MenuItem item18 = new Item18ListOfServicesAndRoomsSortByPrice();
        MenuItem item19 = new Item19RoomInformation();
        MenuItem item0  = new Item0QuitToMain();
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
