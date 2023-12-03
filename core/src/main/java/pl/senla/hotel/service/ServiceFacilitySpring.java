package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.senla.hotel.comparators.*;
import pl.senla.hotel.dao.DaoHotelFacilitySpring;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.facilities.RoomLevel;
import pl.senla.hotel.entity.facilities.RoomStatus;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

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
    public Room create(String hotelFacilityString) {
        String[] facilityData = hotelFacilityString.split(";");
        Room hotelFacility = new Room();
        hotelFacility.setCategory(CategoryFacility.valueOf(facilityData[0]));
        hotelFacility.setNameFacility(facilityData[1]);
        hotelFacility.setPrice(Integer.parseInt(facilityData[2]));
        hotelFacility.setCapacity(Integer.parseInt(facilityData[3]));
        hotelFacility.setRoomLevel(RoomLevel.valueOf(facilityData[4]));
        hotelFacility.setRoomStatus(RoomStatus.valueOf(facilityData[5]));
        Room savedRoom = daoHotelFacility.save(hotelFacility);
        log.debug("Create new HotelFacility");
        return savedRoom;
    }

    @Override
    public Room read(int idFacility) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        Optional<Room> hotelFacility = daoHotelFacility.findById(idFacility);
        if(hotelFacility.isPresent()){
            log.debug("Read HotelFacility.");
            return hotelFacility.get();
        }
        log.debug(READ_HOTEL_FACILITY_NOT_EXIST);
        return null;
    }

    @Override
    public Room update(int idFacility, String hotelFacilityString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(daoHotelFacility.existsById(idFacility)){
            Room hotelFacilityUpdate = read(idFacility);
            hotelFacilityUpdate.setPrice(Integer.parseInt(hotelFacilityString));
            log.debug("Update HotelFacility");
            return daoHotelFacility.save(hotelFacilityUpdate);
        }
        log.debug(ROOM_NOT_EXISTS);
        return null;
    }

    @Override
    public void delete(int idFacility) throws InvocationTargetException, NoSuchMethodException,
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
        return readAll()
                .stream()
                .sorted(new HotelFacilityComparatorByCategory())
                .toList();
    }

    @Override
    public List<Room> readPriceListForServicesSortByPrice() {
        log.debug("PriceListForServicesSortByPrice:");
        return readAll()
                .stream()
                .sorted(new HotelFacilityComparatorByPrice())
                .toList();
    }

    @Override
    public List<Room> readAllRoomsSortByPrice() {
        log.debug("AllRoomsSortByPrice:");
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM))
                .sorted(new RoomComparatorByPrice())
                .toList();
    }

    @Override
    public List<Room> readAllRoomsSortByCapacity() {
        log.debug("AllRoomsSortByCapacity:");
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM))
                .sorted(new RoomComparatorByCapacity())
                .toList();
    }

    @Override
    public List<Room> readAllRoomsSortByLevel() {
        log.debug("AllRoomsSortByLevel:");
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM))
                .sorted(new RoomComparatorByLevel())
                .toList();
    }

    @Override
    public Room updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (changeRoomStatusEnabled){
            if (daoHotelFacility.existsById(idRoom)) {
                Room roomUpdate = read(idRoom);
                roomUpdate.makeRoomAvailable();
                log.debug("Set RoomStatus Available.");
                daoHotelFacility.save(roomUpdate);
            }
            log.debug(ROOM_NOT_EXISTS);
        }
        log.debug(ERROR_NO_PERMISSION);
        return null;
    }

    @Override
    public Room updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (changeRoomStatusEnabled){
            if (daoHotelFacility.existsById(idRoom)) {
                Room roomUpdate = read(idRoom);
                roomUpdate.makeRoomRepaired();
                log.debug("Set RoomStatus Repaired.");
                daoHotelFacility.save(roomUpdate);
            }
            log.debug(ROOM_NOT_EXISTS);
        }
        log.debug(ERROR_NO_PERMISSION);
        return null;
    }
}
