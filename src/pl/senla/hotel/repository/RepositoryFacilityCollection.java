package pl.senla.hotel.repository;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageFacility;

import java.util.List;

public class RepositoryFacilityCollection implements Repository<HotelFacility> {

    private static Repository<HotelFacility> repositoryFacility;
    private final DataStorage<HotelFacility> priceList;

    private RepositoryFacilityCollection() {
        this.priceList = DataStorageFacility.getDataStorageFacility();
    }

    public static Repository<HotelFacility> getRepositoryFacility(){
        if(repositoryFacility == null){
            repositoryFacility = new RepositoryFacilityCollection();
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
