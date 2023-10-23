package pl.senla.hotel.repository;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.storage.DataStorage;

import java.util.List;

@AppComponent
public class RepositoryFacilityCollection implements Repository<HotelFacility> {

    @GetInstance(beanName = "DataStorageFacility")
    private DataStorage<HotelFacility> priceList;

    public RepositoryFacilityCollection() {    }

    @Override
    public List<HotelFacility> readAll() {
        return priceList.getDataList();
    }

    @Override
    public boolean create(HotelFacility hotelFacility) {
        return readAll().add(hotelFacility);
    }

    @Override
    public HotelFacility read(int idFacility) {
        return readAll().get(idFacility);
    }

    @Override
    public boolean update(int idFacility, HotelFacility hotelFacility) {
        readAll().set(idFacility, hotelFacility);
        return true;
    }

    @Override
    public boolean delete(int idFacility) {
        readAll().remove(idFacility);
        return true;
    }
}
