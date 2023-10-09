package pl.senla.hotel.controller;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.service.ServiceFacility;
import pl.senla.hotel.service.ServiceRoom;

import java.util.List;

@AppComponent
public class ControllerFacilityCollection implements ControllerFacility{

    private static ControllerFacility controllerFacility;
    @GetInstance(beanName = "ServiceFacilityImpl")
    private final ServiceFacility serviceFacility;
    @GetInstance(beanName = "ServiceRoomImpl")
    private final ServiceRoom serviceRoom;

    private ControllerFacilityCollection(ServiceFacility serviceFacility, ServiceRoom serviceRoom) {
        this.serviceFacility = serviceFacility;
        this.serviceRoom = serviceRoom;
    }

    public static ControllerFacility getSingletonInstance(ServiceFacility serviceFacility, ServiceRoom serviceRoom){
        if(controllerFacility == null){
            controllerFacility = new ControllerFacilityCollection(serviceFacility, serviceRoom);
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
