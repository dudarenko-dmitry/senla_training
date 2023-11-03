package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.dao.GenericDao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ClientConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ServiceGuestImpl implements ServiceGuest {

    @GetInstance(beanName = "DaoGuestCollection")
    private GenericDao<Guest> daoGuest;

    public ServiceGuestImpl() {}

    @Override
    public List<Guest> readAll() {
        if(daoGuest.readAll() == null || daoGuest.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return Collections.emptyList();
        }
        return daoGuest.readAll();
    }

    @Override
    public boolean create(String guestString) {
        Guest guest = new Guest();
        String[] guestData = guestString.split(";");
        guest.setIdGuest(-1);
        guest.setName(guestData[0]);
        guest.setPhoneNumber(Integer.parseInt(guestData[1]));
        setIdGuestNew(guest);
        return daoGuest.create(guest);
    }

    @Override
    public Guest read(int idGuest) {
        if(daoGuest.readAll() == null || daoGuest.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return null;
        } else if(idGuest < 0 || idGuest >= daoGuest.readAll().size()){
            System.out.println(ERROR_INPUT);
            return null;
        }
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdGuest() == idGuest){
                return daoGuest.read(idGuest);
            }
        }
        System.out.println(ERROR_READ_CLIENT);
        return null;
    }

    @Override
    public boolean update(int idGuest, String guestUpdate) {
        if(daoGuest.readAll() == null || daoGuest.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(read(idGuest) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        Guest guest = read(idGuest);
        guest.setPhoneNumber(Integer.parseInt(guestUpdate));
        return daoGuest.update(idGuest, guest);
    }

    @Override
    public boolean delete(int idGuest) {
        if(daoGuest.readAll() == null || daoGuest.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(read(idGuest) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return daoGuest.delete(idGuest);
    }

    @Override
    public int countNumberOfGuestsTotal() {
        return daoGuest.readAll().size();
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
