package pl.senla.hotel.controller;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.service.ServiceFacility;
import pl.senla.hotel.service.ServiceRoom;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AppComponent
public class ControllerFacilityCollection implements ControllerFacility{

    @GetInstance(beanName = "ServiceFacilityImpl")
    private ServiceFacility serviceFacility;
    @GetInstance(beanName = "ServiceRoomImpl")
    private ServiceRoom serviceRoom;

    public ControllerFacilityCollection() {}

    @Override
    public List<HotelFacility> readAll() {
        return serviceFacility.readAll();
    }

    @Override
    public boolean create(String hotelFacilityString) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        return serviceFacility.create(hotelFacilityString);
    }

    @Override
    public HotelFacility read(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        return serviceFacility.read(id);
    }

    @Override
    public boolean update(int id, String hotelFacilityString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return serviceFacility.update(id, hotelFacilityString);
    }

    @Override
    public boolean updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return serviceRoom.updateRoomStatusAvailable(idRoom);
    }

    @Override
    public boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return serviceRoom.updateRoomStatusRepaired(idRoom);
    }

    @Override
    public boolean delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        return serviceFacility.delete(id);
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByCategory() {
        return serviceFacility.readPriceListForServicesSortByCategory();
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByPrice() {
        return serviceFacility.readPriceListForServicesSortByPrice();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByPrice() {
        return serviceFacility.readAllRoomsSortByPrice();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByCapacity() {
        return serviceFacility.readAllRoomsSortByCapacity();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByLevel() {
        return serviceFacility.readAllRoomsSortByLevel();
    }
}
