package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.service.ServiceGuest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AppComponent
@Slf4j
public class ControllerGuestDB implements ControllerGuest {

    @GetInstance(beanName = "ServiceGuestDB")
    private ServiceGuest guestService;

    public ControllerGuestDB() {}

    @Override
    public List<Guest> readAll() {
        log.debug("ControllerGuest call ServiceGuest's method 'readAll'.");
        return guestService.readAll();
    }

    @Override
    public boolean create(String guest) throws IllegalAccessException,
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
    public boolean update(int id, String guestUpdate) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerGuest call ServiceGuest's method 'update'.");
        return guestService.update(id, guestUpdate);
    }

    @Override
    public boolean delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerGuest call ServiceGuest's method 'delete'.");
        return guestService.delete(id);
    }

    @Override
    public int countNumberOfGuestsTotal() {
        log.debug("ControllerGuest call ServiceGuest's method 'countNumberOfGuestsTotal'.");
        return guestService.countNumberOfGuestsTotal();
    }
}
