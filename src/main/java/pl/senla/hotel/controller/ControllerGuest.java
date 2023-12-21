package pl.senla.hotel.controller;

import pl.senla.hotel.dto.GuestDto;

public interface ControllerGuest extends ControllerCRUDALL<GuestDto> {

    int countNumberOfGuestsTotal();
}
