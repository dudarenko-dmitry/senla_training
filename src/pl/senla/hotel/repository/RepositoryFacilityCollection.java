package pl.senla.hotel.repository;

import pl.senla.hotel.comparators.HotelFacilityComparatorByCategory;
import pl.senla.hotel.comparators.HotelFacilityComparatorByPrice;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageFacility;

import java.util.List;

public class RepositoryFacilityCollection implements RepositoryFacility{

    private final DataStorage<HotelFacility> priceList = new DataStorageFacility();

    @Override
    public List<HotelFacility> readAll() {
        return priceList.getDataList();
    }

    @Override
    public boolean create(HotelFacility hotelFacility) {
        return readAll().add(hotelFacility);
    }

    @Override
    public HotelFacility read(int id) {
        return readAll().get(id);
    }

    @Override
    public boolean update(HotelFacility hotelFacility) {
        return false;
    }

    @Override
    public boolean delete(int id) {
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
}