package pl.senla.hotel.comparators;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.Transfer;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.Restaurant;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.dao.GenericDao;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

import static pl.senla.hotel.constant.HotelServiceConstant.ERROR_IN_SERVICE_TYPE;

@AppComponent
public class HotelServicesComparatorByPrice implements Comparator<HotelService> {

    @GetInstance(beanName = "DaoRoomCollection")
    private GenericDao<Room> daoRoom;

    public HotelServicesComparatorByPrice() {}

    @Override
    public int compare(HotelService o1, HotelService o2) {
        switch(o1.getTypeOfService()){
            case ROOM_RESERVATION -> {
                try {
                    return compareRoomReservation((RoomReservation) o1, (RoomReservation) o2);
                } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            case RESTAURANT -> {return compareRestaurant((Restaurant) o1, (Restaurant) o2);}
            case TRANSFER -> {return compareTransfer((Transfer) o1, (Transfer) o2);}
            default -> {System.out.println(ERROR_IN_SERVICE_TYPE);
                return 0;}
        }
    }

    private int compareRoomReservation(RoomReservation o1, RoomReservation o2) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return daoRoom.read(o1.getIdRoom()).getPrice() - daoRoom.read(o2.getIdRoom()).getPrice();
    }

    private int compareRestaurant(Restaurant o1, Restaurant o2){
        return o1.getPrice() - o2.getPrice();
    }

    private int compareTransfer(Transfer o1, Transfer o2){
        return o1.getPrice() - o2.getPrice();
    }
}
