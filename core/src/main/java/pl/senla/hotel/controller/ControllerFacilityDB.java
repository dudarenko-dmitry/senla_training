package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.service.ServiceFacility;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AppComponent
@Slf4j
public class ControllerFacilityDB implements ControllerFacility{

    @GetInstance(beanName = "ServiceFacilityDB")
    private ServiceFacility serviceFacility;

    public ControllerFacilityDB() {}

    @Override
    public List<Room> readAll() {
        log.debug("ControllerFacility call ServiceFacility's method 'ReadAll'.");
        return serviceFacility.readAll();
    }

    @Override
    public boolean create(String hotelFacilityString) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        log.debug("ControllerFacility call ServiceFacility's method 'Create'.");
        return serviceFacility.create(hotelFacilityString);
    }

    @Override
    public Room read(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'Read'.");
        return serviceFacility.read(id);
    }

    @Override
    public boolean update(int id, String hotelFacilityString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'Update'.");
        return serviceFacility.update(id, hotelFacilityString);
    }

    @Override
    public boolean updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'UpdateRoomStatusAvailable'.");
        return serviceFacility.updateRoomStatusAvailable(idRoom);
    }

    @Override
    public boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'UpdateRoomStatusRepaired'.");
        return serviceFacility.updateRoomStatusRepaired(idRoom);
    }

    @Override
    public boolean delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerFacility call ServiceFacility's method 'Delete'.");
        return serviceFacility.delete(id);
    }

    @Override
    public List<Room> readPriceListForServicesSortByCategory() {
        log.debug("ControllerFacility call ServiceFacility's method 'readPriceListForServicesSortByCategory'.");
        return serviceFacility.readPriceListForServicesSortByCategory();
    }

    @Override
    public List<Room> readPriceListForServicesSortByPrice() {
        log.debug("ControllerFacility call ServiceFacility's method 'readPriceListForServicesSortByPrice'.");
        return serviceFacility.readPriceListForServicesSortByPrice();
    }

    @Override
    public List<Room> readAllRoomsSortByPrice() {
        log.debug("ControllerFacility call ServiceFacility's method 'readAllRoomsSortByPrice'.");
        return serviceFacility.readAllRoomsSortByPrice();
    }

    @Override
    public List<Room> readAllRoomsSortByCapacity() {
        log.debug("ControllerFacility call ServiceFacility's method 'readAllRoomsSortByCapacity'.");
        return serviceFacility.readAllRoomsSortByCapacity();
    }

    @Override
    public List<Room> readAllRoomsSortByLevel() {
        log.debug("ControllerFacility call ServiceFacility's method 'readAllRoomsSortByLevel'.");
        return serviceFacility.readAllRoomsSortByLevel();
    }
}
