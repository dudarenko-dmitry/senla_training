package pl.senla.hotel.comparators;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.repository.Repository;

import java.util.Comparator;

@AppComponent
public class RoomReservationsComparatorByGuestName implements Comparator<RoomReservation> {

    @GetInstance(beanName = "RepositoryGuestCollection")
    private final Repository<Guest> repositoryGuest;

    public RoomReservationsComparatorByGuestName(Repository<Guest> repositoryGuest) {
        this.repositoryGuest = repositoryGuest;
    }

    @Override
    public int compare(RoomReservation o1, RoomReservation o2) {
        int idGuest1 = o1.getIdGuest();
        int idGuest2 = o2.getIdGuest();
        String name1 = repositoryGuest.read(idGuest1).getName();
        String name2 = repositoryGuest.read(idGuest2).getName();
        return name1.compareTo(name2);

    }
}
