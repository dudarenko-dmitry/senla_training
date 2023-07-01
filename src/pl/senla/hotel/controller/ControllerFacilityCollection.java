package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.service.ServiceFacility;
import pl.senla.hotel.service.ServiceFacilityImpl;

import java.util.List;

public class ControllerFacilityCollection implements ControllerFacility{

    private final ServiceFacility serviceFacility = new ServiceFacilityImpl();

    @Override
    public List<HotelFacility> readAll() {
        return serviceFacility.readAll();
    }

    @Override
    public boolean create(HotelFacility hotelFacility) {
        return serviceFacility.create(hotelFacility);
    }

    @Override
    public HotelFacility read(int id) {
        return null;
    }

    @Override
    public boolean update(HotelFacility hotelFacility) {
        return serviceFacility.update(hotelFacility);
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
}
