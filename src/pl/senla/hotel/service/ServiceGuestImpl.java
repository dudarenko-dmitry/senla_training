package pl.senla.hotel.service;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.repository.RepositoryGuest;
import pl.senla.hotel.repository.RepositoryGuestCollection;

import java.util.List;

import static pl.senla.hotel.constant.ClientConstant.*;

public class ServiceGuestImpl implements ServiceGuest {

    private final RepositoryGuest guestRepository = new RepositoryGuestCollection();


    @Override
    public List<Guest> readAll() {
        if(guestRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
        }
        return guestRepository.readAll();
    }

    @Override
    public boolean create(Guest guest) {
        if(read(guest.getIdGuest()) != null && read(guest.getIdGuest()).equals(guest)){
            System.out.println(ERROR_CREATE_CLIENT);
            return false;
        }
        setIdGuestNew(guest);
        return guestRepository.create(guest);
    }

    @Override
    public Guest read(int id) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return null;
        } else if(guestRepository.read(id) == null){
            System.out.println(ERROR_READ_CLIENT);
            return null;
        }
        return guestRepository.read(id);
    }

    @Override
    public boolean update(Guest guest) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(read(guest.getIdGuest()) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return guestRepository.update(guest);
    }

    @Override
    public boolean delete(int id) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(read(id) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return guestRepository.delete(id);
    }

    @Override
    public int countNumberOfGuestsTotal() {
        return guestRepository.countNumberOfGuestsTotal();
    }

    private void setIdGuestNew(Guest guest) {
        int lastId = readAll()
                .stream()
                .map(Guest::getIdGuest)
                .max((o1, o2) -> o1 - o2)
                .orElse(-1);
        guest.setIdGuest(lastId + 1);
    }
}
