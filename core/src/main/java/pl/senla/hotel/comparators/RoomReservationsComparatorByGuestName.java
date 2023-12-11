package pl.senla.hotel.comparators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dao.DaoGuestSpring;
import pl.senla.hotel.entity.services.HotelService;

import java.util.Comparator;

@Component
@Slf4j
public class RoomReservationsComparatorByGuestName implements Comparator<HotelService> {

    @Autowired
    private DaoGuestSpring daoGuest;

    public RoomReservationsComparatorByGuestName() {
    }

    @Override
    public int compare(HotelService o1, HotelService o2) {
        String name1 = o1.getGuest().getName();
        String name2 = o2.getGuest().getName();
        return name1.compareTo(name2);
    }
}
