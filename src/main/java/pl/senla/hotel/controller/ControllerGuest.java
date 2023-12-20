package pl.senla.hotel.controller;

import pl.senla.hotel.entity.Guest;

public interface ControllerGuest extends ControllerCRUDALL<Guest> {

    int countNumberOfGuestsTotal();
}
