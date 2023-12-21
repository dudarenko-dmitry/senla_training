package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.senla.hotel.dto.RoomDto;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.service.ServiceFacility;
import pl.senla.hotel.utils.RoomDtoMapperUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@Slf4j
public class ControllerFacilitySpring implements ControllerFacility{

    @Autowired
    private ServiceFacility serviceFacility;

    @Override
    @GetMapping("/")
    public List<RoomDto> readAll() {
        log.debug("ControllerFacility call ServiceFacility's method 'ReadAll'.");
        return serviceFacility.readAll().stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }

    @Override
    @PostMapping("/")
    public RoomDto create(@RequestBody RoomDto roomDto) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        log.debug("ControllerFacility call ServiceFacility's method 'Create'.");
        return RoomDtoMapperUtil.convertRoomToRoomDto(serviceFacility.create(roomDto));
    }

    @Override
    @GetMapping("/{id}")
    public RoomDto read(@PathVariable int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'Read'.");
        return RoomDtoMapperUtil.convertRoomToRoomDto(serviceFacility.read(id));
    }

    @Override
    @PutMapping("/{id}")
    public RoomDto update(@PathVariable int id, @RequestBody RoomDto RoomDtoNew) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'Update'.");
        return RoomDtoMapperUtil.convertRoomToRoomDto(serviceFacility.update(id, RoomDtoNew));
    }

    @Override
    @PutMapping("/{id}")
    public Room updateRoomStatusAvailable(@PathVariable int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'UpdateRoomStatusAvailable'.");
        return serviceFacility.updateRoomStatusAvailable(idRoom);
    }

    @Override
    @PutMapping("/{id}")
    public Room updateRoomStatusRepaired(@PathVariable int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'UpdateRoomStatusRepaired'.");
        return serviceFacility.updateRoomStatusRepaired(idRoom);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'Delete'.");
        serviceFacility.delete(id);
    }


    // try to replace below methods by creating "?sort=..."
    @Override
    @GetMapping("?sort=status")
    public List<RoomDto> readPriceListForServicesSortByCategory() {
        log.debug("ControllerFacility call ServiceFacility's method 'readPriceListForServicesSortByCategory'.");
        return serviceFacility.readPriceListForServicesSortByCategory().stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }

    @Override
    @GetMapping("?sort=price")
    public List<RoomDto> readPriceListForServicesSortByPrice() {
        log.debug("ControllerFacility call ServiceFacility's method 'readPriceListForServicesSortByPrice'.");
        return serviceFacility.readPriceListForServicesSortByPrice().stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }

    @Override
    @GetMapping("?category=ROOM&sort=price")
    public List<RoomDto> readAllRoomsSortByPrice() {
        log.debug("ControllerFacility call ServiceFacility's method 'readAllRoomsSortByPrice'.");
        return serviceFacility.readAllRoomsSortByPrice().stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }

    @Override
    @GetMapping("?category=ROOM&sort=capacity")
    public List<RoomDto> readAllRoomsSortByCapacity() {
        log.debug("ControllerFacility call ServiceFacility's method 'readAllRoomsSortByCapacity'.");
        return serviceFacility.readAllRoomsSortByCapacity().stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }

    @Override
    @GetMapping("?category=ROOM&sort=level")
    public List<RoomDto> readAllRoomsSortByLevel() {
        log.debug("ControllerFacility call ServiceFacility's method 'readAllRoomsSortByLevel'.");
        return serviceFacility.readAllRoomsSortByLevel().stream()
                .map(RoomDtoMapperUtil::convertRoomToRoomDto)
                .toList();
    }
}
