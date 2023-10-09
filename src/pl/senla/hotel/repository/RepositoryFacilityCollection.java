package pl.senla.hotel.repository;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.storage.DataStorage;

import java.util.List;

@AppComponent
public class RepositoryFacilityCollection implements Repository<HotelFacility> {

    private static Repository<HotelFacility> repositoryFacility;
    @GetInstance(beanName = "DataStorageFacility")
    private final DataStorage<HotelFacility> priceList;

    private RepositoryFacilityCollection(DataStorage<HotelFacility> priceList) {
        this.priceList = priceList;
    }

    public static Repository<HotelFacility> getSingletonInstance(DataStorage<HotelFacility> priceList){
        if(repositoryFacility == null){
            repositoryFacility = new RepositoryFacilityCollection(priceList);
        }
        return repositoryFacility;
    }
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
