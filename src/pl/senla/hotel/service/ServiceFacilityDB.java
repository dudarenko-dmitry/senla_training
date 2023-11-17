package pl.senla.hotel.service;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.comparators.*;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.facilities.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static pl.senla.hotel.constant.HotelFacilityConstant.*;

@Slf4j
@AppComponent
public class ServiceFacilityDB implements ServiceFacility{

    @GetInstance(beanName = "DaoFacilityDB")
    private GenericDao<HotelFacility> daoHotelFacility;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "change-room-status.enabled", type = "Boolean")
    private Boolean changeRoomStatusEnabled;

    public ServiceFacilityDB() {}

    @Override
    public List<HotelFacility> readAll() {
        List<HotelFacility> hotelFacilityList = daoHotelFacility.readAll();
        if(hotelFacilityList.isEmpty()){
            log.debug(READ_ALL_HOTEL_FACILITY_IS_EMPTY);
        }
        log.debug("Read All HotelFacility.");
        return hotelFacilityList;
    }

    @Override
    public boolean create(String hotelFacilityString) {
        String[] facilityData = hotelFacilityString.split(";");
        HotelFacility hotelFacility = new HotelFacility();
        hotelFacility.setCategory(CategoryFacility.valueOf(facilityData[0]));
        hotelFacility.setNameFacility(facilityData[1]);
        hotelFacility.setPrice(Integer.parseInt(facilityData[2]));
        hotelFacility.setCapacity(Integer.parseInt(facilityData[3]));
        hotelFacility.setRoomLevel(RoomLevel.valueOf(facilityData[4]));
        hotelFacility.setRoomStatus(RoomStatus.valueOf(facilityData[5]));
        boolean b = daoHotelFacility.create(hotelFacility);
        log.debug("Create new HotelFacility");
        return b;
    }

    @Override
    public HotelFacility read(int idFacility) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        HotelFacility hotelFacility = daoHotelFacility.read(idFacility);
        if(hotelFacility != null){
            log.debug("Read HotelFacility.");
            return hotelFacility;
        }
        log.debug(READ_HOTEL_FACILITY_NOT_EXIST);
        return null;
    }

    @Override
    public boolean update(int idFacility, String hotelFacilityString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(daoHotelFacility.read(idFacility) != null){
            HotelFacility hotelFacilityUpdate = read(idFacility);
            hotelFacilityUpdate.setPrice(Integer.parseInt(hotelFacilityString));
            log.debug("Update HotelFacility");
            return daoHotelFacility.update(idFacility, hotelFacilityUpdate);
        }
        log.debug(ROOM_NOT_EXISTS);
        return false;
    }

    @Override
    public boolean delete(int idFacility) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if(daoHotelFacility.read(idFacility) != null){
            log.debug("Delete HotelFacility.");
            return daoHotelFacility.delete(idFacility);
        }
        log.debug(ROOM_NOT_EXISTS);
        return false;
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByCategory() {
        log.debug("PriceListForServicesSortByCategory:");
        return readAll()
                .stream()
                .sorted(new HotelFacilityComparatorByCategory())
                .toList();
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByPrice() {
        log.debug("PriceListForServicesSortByPrice:");
        return readAll()
                .stream()
                .sorted(new HotelFacilityComparatorByPrice())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByPrice() {
        log.debug("AllRoomsSortByPrice:");
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM))
                .sorted(new RoomComparatorByPrice())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByCapacity() {
        log.debug("AllRoomsSortByCapacity:");
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM))
                .sorted(new RoomComparatorByCapacity())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByLevel() {
        log.debug("AllRoomsSortByLevel:");
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM))
                .sorted(new RoomComparatorByLevel())
                .toList();
    }

    @Override
    public boolean updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (changeRoomStatusEnabled){
            if (read(idRoom) != null) {
                HotelFacility roomUpdate = read(idRoom);
                roomUpdate.makeRoomAvailable();
                log.debug("Set RoomStatus Available.");
                return daoHotelFacility.update(idRoom, roomUpdate);
            }
            log.debug(ROOM_NOT_EXISTS);
            return false;
        }
        log.debug(ERROR_NO_PERMISSION);
        return false;
    }

    @Override
    public boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (changeRoomStatusEnabled){
            if (read(idRoom) != null) {
                HotelFacility roomUpdate = read(idRoom);
                roomUpdate.makeRoomRepaired();
                log.debug("Set RoomStatus Repaired.");
                return daoHotelFacility.update(idRoom, roomUpdate);
            }
            log.debug(ROOM_NOT_EXISTS);
            return false;
        }
        log.debug(ERROR_NO_PERMISSION);
        return false;
    }
}
