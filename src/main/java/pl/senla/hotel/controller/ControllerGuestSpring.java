package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.senla.hotel.dto.GuestDto;
import pl.senla.hotel.service.ServiceGuest;
import pl.senla.hotel.utils.GuestDtoMapperUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/guests")
@Slf4j
public class ControllerGuestSpring implements ControllerGuest {

    @Autowired
    private ServiceGuest guestService;

    @Override
    @GetMapping
    public List<GuestDto> readAll() {
        log.debug("ControllerGuest call ServiceGuest's method 'readAll'.");
        return guestService.readAll().stream()
                .map(GuestDtoMapperUtil::convertGuestToGuestDto)
                .toList();
    }

    @Override
    @PostMapping("/")
    public GuestDto create(@RequestBody GuestDto guestDto) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        log.debug("ControllerGuest call ServiceGuest's method 'create'.");
        return GuestDtoMapperUtil.convertGuestToGuestDto(guestService.create(guestDto));
    }

    @Override
    @GetMapping("/{id}")
    public GuestDto read(@PathVariable Integer id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerGuest call ServiceGuest's method 'read'.");
        return GuestDtoMapperUtil.convertGuestToGuestDto(guestService.read(id));
    }

    @Override
    @PutMapping("/{id}")
    public GuestDto update(@PathVariable Integer id, @RequestBody GuestDto guestDtoNew) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerGuest call ServiceGuest's method 'update'.");
        return GuestDtoMapperUtil.convertGuestToGuestDto(guestService.update(id, guestDtoNew));
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerGuest call ServiceGuest's method 'delete'.");
        guestService.delete(id);
    }

    @Override
    @GetMapping("/count-guests")
    public Integer countNumberOfGuestsTotal() {
        log.debug("ControllerGuest call ServiceGuest's method 'countNumberOfGuestsTotal'.");
        return guestService.countNumberOfGuestsTotal();
    }
}
