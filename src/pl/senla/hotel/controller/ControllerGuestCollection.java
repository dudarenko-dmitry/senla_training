package pl.senla.hotel.controller;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.service.ServiceGuest;

import java.util.List;

@AppComponent
public class ControllerGuestCollection implements ControllerGuest {

    private static ControllerGuest controllerGuest;
    @GetInstance(beanName = "ServiceGuestImpl")
    private final ServiceGuest guestService;

    private ControllerGuestCollection(ServiceGuest guestService) {
        this.guestService = guestService;
    }

    public static ControllerGuest getSingletonInstance(ServiceGuest guestService){
        if(controllerGuest == null){
            controllerGuest = new ControllerGuestCollection(guestService);
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
