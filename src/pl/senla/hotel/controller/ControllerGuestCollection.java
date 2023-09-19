package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.service.ServiceGuest;
import pl.senla.hotel.service.ServiceGuestImpl;

import java.util.List;

public class ControllerGuestCollection implements ControllerGuest {

    private static ControllerGuest controllerGuest;
    private final ServiceGuest guestService;

    private ControllerGuestCollection() {
        this.guestService = ServiceGuestImpl.getServiceGuest();
    }

    public static ControllerGuest getControllerGuest(){
        if(controllerGuest == null){
            controllerGuest = new ControllerGuestCollection();
        }
        return controllerGuest;
    }

    @Override
    public List<Guest> readAll() {
        return guestService.readAll();
    }

    @Override
    public boolean create(String guest) {
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