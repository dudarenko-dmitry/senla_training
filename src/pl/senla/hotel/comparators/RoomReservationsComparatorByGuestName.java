package pl.senla.hotel.comparators;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.dao.GenericDao;

import java.util.Comparator;

@AppComponent
public class RoomReservationsComparatorByGuestName implements Comparator<RoomReservation> {

    @GetInstance(beanName = "DaoGuestCollection")
    private GenericDao<Guest> daoGuest;

    public RoomReservationsComparatorByGuestName() {
    }

    @Override
    public int compare(RoomReservation o1, RoomReservation o2) {
        int idGuest1 = o1.getIdGuest();
        int idGuest2 = o2.getIdGuest();
        String name1 = daoGuest.read(idGuest1).getName();
        String name2 = daoGuest.read(idGuest2).getName();
        return name1.compareTo(name2);

    }
}
