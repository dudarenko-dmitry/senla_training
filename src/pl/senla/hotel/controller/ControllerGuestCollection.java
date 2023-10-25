package pl.senla.hotel.controller;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.service.ServiceGuest;

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
    public boolean create(String guest) throws IllegalAccessException {
        return guestService.create(guest);
    }

    @Override
    public Guest read(int id) {
        return guestService.read(id);
    }

    @Override
    public boolean update(int id, String guestUpdate) {
        return guestService.update(id, guestUpdate);
    }

    @Override
    public boolean delete(int id) {
        return guestService.delete(id);
    }

    @Override
    public int countNumberOfGuestsTotal() {
        return guestService.countNumberOfGuestsTotal();
    }
}
