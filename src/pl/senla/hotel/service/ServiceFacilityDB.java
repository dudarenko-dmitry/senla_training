package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.comparators.*;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.facilities.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static pl.senla.hotel.constant.HotelFacilityConstant.*;

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
            System.out.println(READ_ALL_HOTEL_FACILITY_IS_EMPTY);
        }
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
        return daoHotelFacility.create(hotelFacility);
    }

    @Override
    public HotelFacility read(int idFacility) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if(daoHotelFacility.read(idFacility) != null){
            return daoHotelFacility.read(idFacility);
        }
        System.out.println(READ_HOTEL_FACILITY_NOT_EXIST);
        return null;
    }

    @Override
    public boolean update(int idFacility, String hotelFacilityString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(daoHotelFacility.read(idFacility) != null){
            HotelFacility hotelFacilityUpdate = read(idFacility);
            hotelFacilityUpdate.setPrice(Integer.parseInt(hotelFacilityString));
            return daoHotelFacility.update(idFacility, hotelFacilityUpdate);
        }
        System.out.println(ROOM_NOT_EXISTS);
        return false;
    }

    @Override
    public boolean delete(int idFacility) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if(daoHotelFacility.read(idFacility) != null){
            return daoHotelFacility.delete(idFacility);
        }
        System.out.println(ROOM_NOT_EXISTS);
        return false;
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByCategory() {
        return readAll()
                .stream()
                .sorted(new HotelFacilityComparatorByCategory())
                .toList();
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByPrice() {
        return readAll()
                .stream()
                .sorted(new HotelFacilityComparatorByPrice())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByPrice() {
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM))
                .sorted(new RoomComparatorByPrice())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByCapacity() {
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM))
                .sorted(new RoomComparatorByCapacity())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByLevel() {
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
                return daoHotelFacility.update(idRoom, roomUpdate);
            }
            System.out.println(ROOM_NOT_EXISTS);
            return false;
        }
        System.out.println(ERROR_NO_PERMISSION);
        return false;
    }

    @Override
    public boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (changeRoomStatusEnabled){
            if (read(idRoom) != null) {
                HotelFacility roomUpdate = read(idRoom);
                roomUpdate.makeRoomRepaired();
                return daoHotelFacility.update(idRoom, roomUpdate);
            }
            System.out.println(ROOM_NOT_EXISTS);
            return false;
        }
        System.out.println(ERROR_NO_PERMISSION);
        return false;
    }
}
