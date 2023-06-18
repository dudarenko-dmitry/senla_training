package pl.senla.hotel.repository;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageGuest;

import java.util.List;

public class GuestRepositoryCollection implements Repository<Guest> {

    private final DataStorage<Guest> dataStorage = new DataStorageGuest();

    @Override
    public List<Guest> readAll() {
        return dataStorage.getDataList();
    }

    @Override
    public boolean create(Guest guest) {
        readAll().add(guest);
        return true;
    }

    @Override
    public Guest read(int id) {
        Guest guestRead = null;
        for(Guest c : readAll()){
            if(id == c.getIdGuest()){
                guestRead = c;
            }
        }
        return guestRead;
    }

    @Override
    public boolean update(Guest guest) {
        int idGuest = guest.getIdGuest();
        readAll().set(idGuest, guest);
        return true;
    }

    @Override
    public boolean delete(int id) {
        readAll().remove(id);
        return true;
    }
}
