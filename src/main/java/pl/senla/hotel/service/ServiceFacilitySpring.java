package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.senla.hotel.dao.DaoHotelFacilitySpring;
import pl.senla.hotel.dto.RoomDto;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.facilities.RoomStatus;
import pl.senla.hotel.exceptions.RoomNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static pl.senla.hotel.constant.HotelFacilityConstant.*;

@Service
@Slf4j
public class ServiceFacilitySpring implements ServiceFacility{

    @Autowired
    private DaoHotelFacilitySpring daoHotelFacility;
    @Value("${change-room-status.enabled}")
    private Boolean changeRoomStatusEnabled;

    @Override
    public List<Room> readAll() {
        List<Room> hotelFacilityList = daoHotelFacility.findAll();
        if(hotelFacilityList.isEmpty()){
            log.debug(READ_ALL_HOTEL_FACILITY_IS_EMPTY);
        }
        log.debug("Read All HotelFacility.");
        return hotelFacilityList;
    }

    @Override
    public Room create(RoomDto roomDto) {
        Room room = new Room();
        room.setCategory(roomDto.getCategory());
        room.setNameFacility(roomDto.getNameFacility());
        room.setPrice(roomDto.getPrice());
        room.setCapacity(roomDto.getCapacity());
        room.setRoomLevel(roomDto.getRoomLevel());
        room.setRoomStatus(RoomStatus.AVAILABLE);
        log.debug("Create new HotelFacility");
        return daoHotelFacility.save(room);
    }

    @Override
    public Room read(Integer idFacility) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("Read HotelFacility.");
        return daoHotelFacility.findById(idFacility)
                .orElseThrow(() -> new RoomNotFoundException(idFacility));
    }

    @Override
    public Room update(Integer idFacility, RoomDto roomDtoNew) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(daoHotelFacility.existsById(idFacility)){
            Room roomUpdate = read(idFacility);
            roomUpdate.setCategory(roomDtoNew.getCategory());
            roomUpdate.setNameFacility(roomDtoNew.getNameFacility());
            roomUpdate.setPrice(roomDtoNew.getPrice());
            roomUpdate.setRoomLevel(roomDtoNew.getRoomLevel());
            roomUpdate.setRoomStatus(roomDtoNew.getRoomStatus());
            log.debug("Update HotelFacility");
            return daoHotelFacility.save(roomUpdate);
        }
        log.debug(ROOM_NOT_EXISTS);
        return null;
    }

    @Override
    public void delete(Integer idFacility) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if(daoHotelFacility.existsById(idFacility)){
            log.debug("Delete HotelFacility.");
            daoHotelFacility.deleteById(idFacility);
        }
        log.debug(ROOM_NOT_EXISTS);
    }

    @Override
    public List<Room> readPriceListForServicesSortByCategory() {
        log.debug("PriceListForServicesSortByCategory:");
        return daoHotelFacility.findByOrderByCategory();
    }

    @Override
    public List<Room> readPriceListForServicesSortByPrice() {
        log.debug("PriceListForServicesSortByPrice:");
        return daoHotelFacility.findByOrderByPrice();
    }

    @Override
    public List<Room> readAllRoomsSortByPrice() {
        log.debug("AllRoomsSortByPrice:");
        return daoHotelFacility.findByOrderByPrice();
    }

    @Override
    public List<Room> readAllRoomsSortByCapacity() {
        log.debug("AllRoomsSortByCapacity:");
        return daoHotelFacility.findByOrderByCapacity();
    }

    @Override
    public List<Room> readAllRoomsSortByLevel() {
        log.debug("AllRoomsSortByLevel:");
        return daoHotelFacility.findByOrderByRoomLevel();
    }

    @Override
    public Room updateRoomStatusAvailable(Integer idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (changeRoomStatusEnabled) {
            if(daoHotelFacility.existsById(idRoom)){
                Room roomUpdate = read(idRoom);
                roomUpdate.setRoomStatus(RoomStatus.AVAILABLE);
                log.debug("Set HotelFacility's status AVAILABLE");
                return daoHotelFacility.save(roomUpdate);
            }
            log.debug(ROOM_NOT_EXISTS);
        }
        log.debug(ERROR_NO_PERMISSION);
        return null;
    }

    @Override
    public Room updateRoomStatusRepaired(Integer idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (changeRoomStatusEnabled){
            if(daoHotelFacility.existsById(idRoom)){
                Room roomUpdate = read(idRoom);
                roomUpdate.setRoomStatus(RoomStatus.REPAIRED);
                log.debug("Set HotelFacility's status UNDER REPAIR");
                return daoHotelFacility.save(roomUpdate);
            }
            log.debug(ROOM_NOT_EXISTS);
        }
        log.debug(ERROR_NO_PERMISSION);
        return null;
    }

    @Override
    public Room getRoomByNameFacility(String nameFacility) {
        log.debug("getRoomByNameFacility:");
        return daoHotelFacility.getRoomByNameFacility(nameFacility);
    }
}
