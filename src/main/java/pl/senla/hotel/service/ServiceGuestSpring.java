package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.senla.hotel.dao.DaoGuestSpring;
import pl.senla.hotel.dto.GuestDto;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.exceptions.GuestNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static pl.senla.hotel.constant.ClientConstant.CLIENT_NOT_EXISTS;

@Service
@Slf4j
public class ServiceGuestSpring implements ServiceGuest {

    @Autowired
    private DaoGuestSpring daoGuest;

    @Override
    public List<Guest> readAll() {
        log.debug("Service: GuestReadAll");
        return daoGuest.findAll();
    }

    @Override
    public Guest create(GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setName(guestDto.getName());
        guest.setPhoneNumber(guestDto.getPhoneNumber());
        log.debug("Service: GuestCreate");
        return daoGuest.save(guest);
    }

    @Override
    public Guest read(Integer idGuest) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("Service: GuestRead");
        return daoGuest.findById(idGuest)
                .orElseThrow(() -> new GuestNotFoundException(idGuest)) ;
    }

    @Override
    public Guest update(Integer idGuest, GuestDto guestDtoUpdate) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("Service: GuestUpdate");
        if(daoGuest.existsById(idGuest)){
            Guest guest = read(idGuest);
            guest.setName(guestDtoUpdate.getName());
            guest.setPhoneNumber(guestDtoUpdate.getPhoneNumber());
            return daoGuest.save(guest);
        }
        log.debug(CLIENT_NOT_EXISTS);
        return null;
    }

    @Override
    public void delete(Integer idGuest) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("Service: GuestDelete");
        if(daoGuest.existsById(idGuest)){
            daoGuest.deleteById(idGuest);
        }
        log.debug(CLIENT_NOT_EXISTS);
    }

    @Override
    public Integer countNumberOfGuestsTotal() {
        log.debug("Service: CountGuest");
        return daoGuest.countFindAll();
    }

    @Override
    public Guest getGuestByName(String name) {
        log.debug("Service: getGuestByName");
        return  daoGuest.getGuestByName(name);
    }
}
