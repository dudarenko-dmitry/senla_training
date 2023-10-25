package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.repository.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ClientConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ServiceGuestImpl implements ServiceGuest {

    @GetInstance(beanName = "RepositoryGuestCollection")
    private Repository<Guest> guestRepository;

    public ServiceGuestImpl() {}

    @Override
    public List<Guest> readAll() {
        if(guestRepository.readAll() == null || guestRepository.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return Collections.emptyList();
        }
        return guestRepository.readAll();
    }

    @Override
    public boolean create(String guestString) {
        Guest guest = new Guest();
        String[] guestData = guestString.split(";");
        guest.setIdGuest(-1);
        guest.setName(guestData[0]);
        guest.setPhoneNumber(Integer.parseInt(guestData[1]));
        setIdGuestNew(guest);
        return guestRepository.create(guest);
    }

    @Override
    public Guest read(int idGuest) {
        if(guestRepository.readAll() == null || guestRepository.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return null;
        } else if(idGuest < 0 || idGuest >= guestRepository.readAll().size()){
            System.out.println(ERROR_INPUT);
            return null;
        }
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdGuest() == idGuest){
                return guestRepository.read(idGuest);
            }
        }
        System.out.println(ERROR_READ_CLIENT);
        return null;
    }

    @Override
    public boolean update(int idGuest, String guestUpdate) {
        if(guestRepository.readAll() == null || guestRepository.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(read(idGuest) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        Guest guest = read(idGuest);
        guest.setPhoneNumber(Integer.parseInt(guestUpdate));
        return guestRepository.update(idGuest, guest);
    }

    @Override
    public boolean delete(int idGuest) {
        if(guestRepository.readAll() == null || guestRepository.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(read(idGuest) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return guestRepository.delete(idGuest);
    }

    @Override
    public int countNumberOfGuestsTotal() {
        return guestRepository.readAll().size();
    }

    private void setIdGuestNew(Guest guest) {
        int lastId = readAll()
                .stream()
                .map(Guest::getIdGuest)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        guest.setIdGuest(lastId + 1);
    }
}
