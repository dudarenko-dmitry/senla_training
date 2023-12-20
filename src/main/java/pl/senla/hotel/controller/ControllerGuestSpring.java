package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.service.ServiceGuest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@Slf4j
public class ControllerGuestSpring implements ControllerGuest {

    @Autowired
    private ServiceGuest guestService;

    @Override
    public List<Guest> readAll() {
        log.debug("ControllerGuest call ServiceGuest's method 'readAll'.");
        return guestService.readAll();
    }

    @Override
    public Guest create(String guest) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        log.debug("ControllerGuest call ServiceGuest's method 'create'.");
        return guestService.create(guest);
    }

    @Override
    public Guest read(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerGuest call ServiceGuest's method 'read'.");
        return guestService.read(id);
    }

    @Override
    public Guest update(int id, String guestUpdate) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerGuest call ServiceGuest's method 'update'.");
        return guestService.update(id, guestUpdate);
    }

    @Override
    public void delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerGuest call ServiceGuest's method 'delete'.");
        guestService.delete(id);
    }

    @Override
    public int countNumberOfGuestsTotal() {
        log.debug("ControllerGuest call ServiceGuest's method 'countNumberOfGuestsTotal'.");
        return guestService.countNumberOfGuestsTotal();
    }
}
