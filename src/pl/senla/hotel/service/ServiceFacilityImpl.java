package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.repository.RepositoryFacility;
import pl.senla.hotel.repository.RepositoryFacilityCollection;

import java.util.List;

public class ServiceFacilityImpl implements ServiceFacility{

    private final RepositoryFacility repositoryHotelFacility;

    public ServiceFacilityImpl() {
        this.repositoryHotelFacility = new RepositoryFacilityCollection();
    }

    @Override
    public List<HotelFacility> readAll() {
        return repositoryHotelFacility.readAll();
    }

    @Override
    public boolean create(String hotelFacilityString) {
        return repositoryHotelFacility.create(null); // null !!!
    }

    @Override
    public HotelFacility read(int id) {
        return repositoryHotelFacility.read(id);
    }

    @Override
    public boolean update(int id, String hotelFacilityString) {
        return repositoryHotelFacility.update(null); // null !!!
    }

    @Override
    public boolean delete(int id) {
        return repositoryHotelFacility.delete(id);
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByCategory() {
        return repositoryHotelFacility.readPriceListForServicesSortByCategory();
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByPrice() {
        return repositoryHotelFacility.readPriceListForServicesSortByPrice();
    }
}
