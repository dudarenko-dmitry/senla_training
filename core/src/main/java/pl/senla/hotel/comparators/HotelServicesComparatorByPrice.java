package pl.senla.hotel.comparators;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.services.TypeOfService;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Objects;

import static pl.senla.hotel.constant.HotelServiceConstant.ERROR_IN_SERVICE_TYPE;

@AppComponent
@Slf4j
public class HotelServicesComparatorByPrice implements Comparator<HotelService> {

    @GetInstance(beanName = "DaoFacilityDB")
    private GenericDao<Room> daoRoom;

    public HotelServicesComparatorByPrice() {}

    @Override
    public int compare(HotelService o1, HotelService o2) {
        if (Objects.requireNonNull(o1.getTypeOfService()) == TypeOfService.ROOM_RESERVATION) {
            try {
                return compareRoomReservation(o1, o2);
            } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        log.warn(ERROR_IN_SERVICE_TYPE);
        return 0;
    }

    private int compareRoomReservation(HotelService o1, HotelService o2) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return daoRoom.read(o1.getRoom().getIdRoom()).getPrice() - daoRoom.read(o2.getRoom().getIdRoom()).getPrice();
    }
}
