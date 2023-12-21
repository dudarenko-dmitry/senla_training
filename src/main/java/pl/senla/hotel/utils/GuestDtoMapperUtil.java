package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.GuestDto;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.service.ServiceGuest;

@Component
@Slf4j
public class GuestDtoMapperUtil {

    private GuestDtoMapperUtil() {}

    @Autowired
    private static ServiceGuest serviceGuest;

    public static Guest convertGuestDtoToGuest(GuestDto guestDto) {
        log.debug("Start: convert GuestDto to Guest");
        return Guest.builder()
                .idGuest(serviceGuest.getGuestByName(guestDto.getName()).getIdGuest())
                .name(guestDto.getName())
                .phoneNumber(guestDto.getPhoneNumber())
                .build();
    }


    public static GuestDto convertGuestToGuestDto(Guest guest) {
        log.debug("Start: convert Guest to GuestDto");
        return GuestDto.builder()
                .name(guest.getName())
                .phoneNumber(guest.getPhoneNumber())
                .build();
    }

}
