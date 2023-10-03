package pl.senla.hotel.controller;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.service.ServiceFacility;
import pl.senla.hotel.service.ServiceFacilityImpl;
import pl.senla.hotel.service.ServiceRoom;
import pl.senla.hotel.service.ServiceRoomImpl;

import java.util.List;

public class ControllerFacilityCollection implements ControllerFacility{

    private static ControllerFacility controllerFacility;
    private final ServiceFacility serviceFacility;
    private final ServiceRoom serviceRoom;

    private ControllerFacilityCollection(Configuration appConfiguration) {
        this.serviceFacility = ServiceFacilityImpl.getServiceFacility();
        this.serviceRoom = ServiceRoomImpl.getServiceRoom(appConfiguration);
    }

    public static ControllerFacility getControllerFacility(Configuration appConfiguration){
        if(controllerFacility == null){
            controllerFacility = new ControllerFacilityCollection(appConfiguration);
        }
        return controllerFacility;
    }

    @Override
    public List<HotelFacility> readAll() {
        return serviceFacility.readAll();
    }

    @Override
    public boolean create(String hotelFacilityString) {
        return serviceFacility.create(hotelFacilityString);
    }

    @Override
    public HotelFacility read(int id) {
        return serviceFacility.read(id);
    }

    @Override
    public boolean update(int id, String hotelFacilityString) {
        return serviceFacility.update(id, hotelFacilityString);
    }

    @Override
    public boolean updateRoomStatusAvailable(int idRoom){
        return serviceRoom.updateRoomStatusAvailable(idRoom);
    }

    @Override
    public boolean updateRoomStatusRepaired(int idRoom){
        return serviceRoom.updateRoomStatusRepaired(idRoom);
    }

    @Override
    public boolean delete(int id) {
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
