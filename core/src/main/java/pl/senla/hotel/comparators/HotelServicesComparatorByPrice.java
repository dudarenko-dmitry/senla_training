package pl.senla.hotel.comparators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dao.DaoHotelFacilitySpring;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.TypeOfService;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

import static pl.senla.hotel.constant.HotelServiceConstant.ERROR_IN_SERVICE_TYPE;

@Component
@Slf4j
public class HotelServicesComparatorByPrice implements Comparator<HotelService> {

    @Autowired
    private DaoHotelFacilitySpring daoRoom;

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
        Optional<Room> room1 = daoRoom.findById(o1.getRoom().getIdRoom());
        Optional<Room> room2 = daoRoom.findById(o2.getRoom().getIdRoom());
        if (room1.isPresent() && room2.isPresent()) {
            return room1.get().getPrice() - room2.get().getPrice();
        }
        log.info("One (or all) of compared rooms is not exist!");
        return 0;
    }
}
