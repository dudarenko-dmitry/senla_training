package pl.senla.hotel.repository;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageGuest;

import java.util.List;

public class RepositoryGuestCollection implements RepositoryGuest {

    private static RepositoryGuest repositoryGuest;
    private final DataStorage<Guest> dataStorage;

    private RepositoryGuestCollection() {
        this.dataStorage = DataStorageGuest.getDataStorageGuest();
    }

    public static RepositoryGuest getRepositoryGuest(){
        if(repositoryGuest == null){
            repositoryGuest = RepositoryGuestCollection.getRepositoryGuest();
            System.out.println("Repository for Guest was created.");
        }
        return repositoryGuest;
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

    @Override
    public int countNumberOfGuestsTotal() {
        return readAll().size();
    }
}
