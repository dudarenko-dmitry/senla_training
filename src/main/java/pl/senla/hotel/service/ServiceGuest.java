package pl.senla.hotel.service;

import pl.senla.hotel.dto.GuestDto;
import pl.senla.hotel.entity.Guest;

public interface ServiceGuest extends ServiceCRUDALL<Guest, GuestDto> {

    int countNumberOfGuestsTotal();

    Guest getGuestByName(String name);
}
