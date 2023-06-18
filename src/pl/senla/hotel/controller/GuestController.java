package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.service.GuestService;
import pl.senla.hotel.service.Service;

import java.util.List;

public class GuestController implements Controller<Guest>{

    private final Service<Guest> guestService = new GuestService();

    @Override
    public List<Guest> readAll() {
        return guestService.readAll();
    }

    @Override
    public boolean create(Guest guest) {
        return guestService.create(guest);
    }

    @Override
    public Guest read(int id) {
        return guestService.read(id);
    }

    @Override
    public boolean update(Guest guest) {
        return guestService.update(guest);
    }

    @Override
    public boolean delete(int id) {
        return guestService.delete(id);
    }
}
