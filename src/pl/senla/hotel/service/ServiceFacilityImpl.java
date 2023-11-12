package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.comparators.*;
import pl.senla.hotel.entity.facilities.*;
import pl.senla.hotel.dao.GenericDao;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.HotelFacilityConstant.*;

@AppComponent
public class ServiceFacilityImpl implements ServiceFacility{

    @GetInstance(beanName = "DaoFacilityCollection")
    private GenericDao<HotelFacility> daoHotelFacility;
    @GetInstance(beanName = "DaoRoomCollection")
    private GenericDao<Room> daoRoom;

    public ServiceFacilityImpl() {}

    @Override
    public List<HotelFacility> readAll() {
        if(daoHotelFacility.readAll() == null || daoHotelFacility.readAll().isEmpty()){
            System.out.println(READ_ALL_HOTEL_FACILITY_IS_EMPTY);
            return Collections.emptyList();
        }
        return daoHotelFacility.readAll();
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
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdFacility() == idFacility){
                return daoHotelFacility.read(idFacility);
            }
        }
        System.out.println(READ_HOTEL_FACILITY_NOT_EXIST);
        return null;
    }

    @Override
    public boolean update(int idFacility, String hotelFacilityString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        HotelFacility hotelFacilityUpdate = read(idFacility);
        hotelFacilityUpdate.setPrice(Integer.parseInt(hotelFacilityString));
        daoRoom.update(idFacility, (Room) hotelFacilityUpdate);
        return daoHotelFacility.update(idFacility, hotelFacilityUpdate);
    }

    @Override
    public boolean delete(int idFacility) {
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdFacility() == idFacility){
                daoRoom.delete(idFacility);
                return daoHotelFacility.delete(idFacility);
            }
        }
        System.out.println(READ_HOTEL_FACILITY_NOT_EXIST);
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
