package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.comparators.*;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.facilities.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.HotelFacilityConstant.*;

@AppComponent
public class ServiceFacilityDB implements ServiceFacility{

    @GetInstance(beanName = "DaoFacilityDB")
    private GenericDao<HotelFacility> daoHotelFacility;

    public ServiceFacilityDB() {}

    @Override
    public List<HotelFacility> readAll() {
        if(daoHotelFacility.readAll() != null || !daoHotelFacility.readAll().isEmpty()){
            return daoHotelFacility.readAll();
        }
        System.out.println(READ_ALL_HOTEL_FACILITY_IS_EMPTY);
        return Collections.emptyList();
    }

    @Override
    public boolean create(String hotelFacilityString) {
        String[] facilityData = hotelFacilityString.split(";");
        Room hotelFacility = new Room();
        hotelFacility.setCategory(CategoryFacility.valueOf(facilityData[0]));
        hotelFacility.setNameFacility(facilityData[1]);
        hotelFacility.setPrice(Integer.parseInt(facilityData[2]));
        hotelFacility.setCapacity(Integer.parseInt(facilityData[3]));
        hotelFacility.setRoomLevel(RoomLevel.valueOf(facilityData[4]));
        hotelFacility.setRoomStatus(RoomStatus.valueOf(facilityData[5]));
        setIdFacilityNew(hotelFacility);
//        daoRoom.create(hotelFacility);
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
//        daoRoom.update(idFacility, (Room) hotelFacilityUpdate);
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

    private void setIdFacilityNew(HotelFacility hotelFacility) {
        int lastId = readAll()
                .stream()
                .map(HotelFacility::getIdFacility)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        hotelFacility.setIdFacility(lastId + 1);
    }
}
