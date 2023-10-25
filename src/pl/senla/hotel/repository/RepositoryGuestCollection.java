package pl.senla.hotel.repository;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.storage.DataStorage;

import java.util.List;

@AppComponent
public class RepositoryGuestCollection implements Repository<Guest> {

    @GetInstance(beanName = "DataStorageGuest")
    public DataStorage<Guest> dataStorage;

    public RepositoryGuestCollection() {
    }

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
    public boolean update(int id, Guest guest) {
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
