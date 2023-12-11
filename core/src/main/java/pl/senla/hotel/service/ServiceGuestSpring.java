package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.Guest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import static pl.senla.hotel.constant.ClientConstant.CLIENT_NOT_EXISTS;

@Service
@Slf4j
public class ServiceGuestSpring implements ServiceGuest {

    @Autowired
    private GenericDao<Guest> daoGuest;

    @Override
    public List<Guest> readAll() {
        log.debug("START: GuestReadAll");
        return daoGuest.findAll();
    }

    @Override
    public Guest create(String guestString) {
        Guest guest = new Guest();
        String[] guestData = guestString.split(";");
        guest.setName(guestData[0]);
        guest.setPhoneNumber(Integer.parseInt(guestData[1]));
        log.debug("START: GuestCreate");
        return daoGuest.save(guest);
    }

    @Override
    public Guest read(int idGuest) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: GuestRead");
        Optional<Guest> guest = daoGuest.findById(idGuest);
        if(guest.isPresent()) {
            return guest.get();
        }
        log.debug(CLIENT_NOT_EXISTS);
        return null;
    }

    @Override
    public Guest update(int idGuest, String guestUpdate) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("START: GuestUpdate");
        if(daoGuest.existsById(idGuest)){
            Guest guest = read(idGuest);
            guest.setPhoneNumber(Integer.parseInt(guestUpdate));
            return daoGuest.save(guest);
        }
        log.debug(CLIENT_NOT_EXISTS);
        return null;
    }

    @Override
    public void delete(int idGuest) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("START: GuestDelete");
        if(daoGuest.existsById(idGuest)){
            daoGuest.deleteById(idGuest);
        }
        log.debug(CLIENT_NOT_EXISTS);
    }

    @Override
    public int countNumberOfGuestsTotal() {
        log.debug("START: CountGuest");
        return readAll().size();
    }
}
