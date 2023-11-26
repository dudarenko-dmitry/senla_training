package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.Guest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static pl.senla.hotel.constant.ClientConstant.CLIENT_NOT_EXISTS;

@AppComponent
@Slf4j
public class ServiceGuestDB implements ServiceGuest {

    @GetInstance(beanName = "DaoGuestDB")
    private GenericDao<Guest> daoGuest;

    public ServiceGuestDB() {}

    @Override
    public List<Guest> readAll() {
        log.debug("START: GuestReadAll");
        return daoGuest.readAll();
    }

    @Override
    public boolean create(String guestString) {
        Guest guest = new Guest();
        String[] guestData = guestString.split(";");
        guest.setName(guestData[0]);
        guest.setPhoneNumber(Integer.parseInt(guestData[1]));
        log.debug("START: GuestCreate");
        return daoGuest.create(guest);
    }

    @Override
    public Guest read(int idGuest) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: GuestRead");
        if(daoGuest.read(idGuest) != null) {
            return daoGuest.read(idGuest);
        }
        log.debug(CLIENT_NOT_EXISTS);
        return null;
    }

    @Override
    public boolean update(int idGuest, String guestUpdate) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: GuestUpdate");
        if(read(idGuest) != null){
            Guest guest = read(idGuest);
            guest.setPhoneNumber(Integer.parseInt(guestUpdate));
            return daoGuest.update(idGuest, guest);
        }
        log.debug(CLIENT_NOT_EXISTS);
        return false;
    }

    @Override
    public boolean delete(int idGuest) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: GuestDelete");
        if(read(idGuest) != null){
            return daoGuest.delete(idGuest);
        }
        log.debug(CLIENT_NOT_EXISTS);
        return false;
    }

    @Override
    public int countNumberOfGuestsTotal() {
        log.debug("START: CountGuest");
        return daoGuest.readAll().size();
    }
}
