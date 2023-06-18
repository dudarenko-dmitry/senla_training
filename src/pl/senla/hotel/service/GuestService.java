package pl.senla.hotel.service;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.repository.GuestRepositoryCollection;
import pl.senla.hotel.repository.Repository;

import java.util.List;

import static pl.senla.hotel.constant.ClientConstant.*;

public class GuestService implements Service<Guest> {

    private final Repository<Guest> guestRepository = new GuestRepositoryCollection();


    @Override
    public List<Guest> readAll() {
        if(guestRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
        }
        return guestRepository.readAll();
    }

    @Override
    public boolean create(Guest guest) {
        if(guestRepository.read(guest.getIdGuest()) != null){
            System.out.println(ERROR_CREATE_CLIENT);
            return false;
        }
        return guestRepository.create(guest);
    }

    @Override
    public Guest read(int id) {
        if(guestRepository.readAll() == null){
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
        if(guestRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(guestRepository.read(guest.getIdGuest()) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return guestRepository.update(guest);
    }

    @Override
    public boolean delete(int id) {
        if(guestRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(guestRepository.read(id) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return guestRepository.delete(id);
    }
}
