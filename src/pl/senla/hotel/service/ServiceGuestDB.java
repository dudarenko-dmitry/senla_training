package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.Guest;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ClientConstant.READ_ALL_CLIENT_IS_EMPTY;
import static pl.senla.hotel.constant.ClientConstant.CLIENT_NOT_EXISTS;

@AppComponent
public class ServiceGuestDB implements ServiceGuest {

    @GetInstance(beanName = "DaoGuestDB")
    private GenericDao<Guest> daoGuest;

    public ServiceGuestDB() {}

    @Override
    public List<Guest> readAll() {
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
    public Guest read(int idGuest) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if(daoGuest.read(idGuest) != null) {
            return daoGuest.read(idGuest);
        }
        System.out.println(CLIENT_NOT_EXISTS);
        return null;
    }

    @Override
    public boolean update(int idGuest, String guestUpdate) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(read(idGuest) != null){
            Guest guest = read(idGuest);
            guest.setPhoneNumber(Integer.parseInt(guestUpdate));
            return daoGuest.update(idGuest, guest);
        }
        System.out.println(CLIENT_NOT_EXISTS);
        return false;
    }

    @Override
    public boolean delete(int idGuest) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if(read(idGuest) != null){
            return daoGuest.delete(idGuest);
        }
        System.out.println(CLIENT_NOT_EXISTS);
        return false;
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
