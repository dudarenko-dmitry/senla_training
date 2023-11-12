package pl.senla.hotel.controller;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.service.ServiceGuest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AppComponent
public class ControllerGuestCollection implements ControllerGuest {

    @GetInstance(beanName = "ServiceGuestImpl")
    private ServiceGuest guestService;

    public ControllerGuestCollection() {}

    @Override
    public List<Guest> readAll() {
        return guestService.readAll();
    }

    @Override
    public boolean create(String guest) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        return guestService.create(guest);
    }

    @Override
    public Guest read(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        return guestService.read(id);
    }

    @Override
    public boolean update(int id, String guestUpdate) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return guestService.update(id, guestUpdate);
    }

    @Override
    public boolean delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        return guestService.delete(id);
    }

    @Override
    public int countNumberOfGuestsTotal() {
        return guestService.countNumberOfGuestsTotal();
    }
}
