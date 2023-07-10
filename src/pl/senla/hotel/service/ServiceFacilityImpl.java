package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.repository.RepositoryFacility;
import pl.senla.hotel.repository.RepositoryFacilityCollection;

import java.util.List;

public class ServiceFacilityImpl implements ServiceFacility{

    private final RepositoryFacility hotelFacilityService;

    public ServiceFacilityImpl() {
        this.hotelFacilityService = new RepositoryFacilityCollection();
    }

    @Override
    public List<HotelFacility> readAll() {
        return hotelFacilityService.readAll();
    }

    @Override
    public boolean create(HotelFacility hotelFacility) {
        return hotelFacilityService.create(hotelFacility);
    }

    @Override
    public HotelFacility read(int id) {
        return null;
    }

    @Override
    public boolean update(HotelFacility hotelFacility) {
        return hotelFacilityService.update(hotelFacility);
    }

    @Override
    public boolean delete(int id) {
        return hotelFacilityService.delete(id);
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByCategory() {
        return hotelFacilityService.readPriceListForServicesSortByCategory();
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByPrice() {
        return hotelFacilityService.readPriceListForServicesSortByPrice();
    }
}
