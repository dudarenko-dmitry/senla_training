package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.service.ServiceFacility;
import pl.senla.hotel.service.ServiceFacilityImpl;

import java.util.List;

public class ControllerFacilityCollection implements ControllerFacility{

    private final ServiceFacility serviceFacility = ServiceFacilityImpl.getServiceFacility();

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
        return null;
    }

    @Override
    public boolean update(int id, String hotelFacilityString) {
        return serviceFacility.update(id, hotelFacilityString);
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
