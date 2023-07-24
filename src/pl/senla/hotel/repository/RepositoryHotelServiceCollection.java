package pl.senla.hotel.repository;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.storage.DataStorageHotelService;

import java.util.List;

public class RepositoryHotelServiceCollection implements RepositoryHotelService{

    private static RepositoryHotelServiceCollection repositoryHotelService;
    private final DataStorageHotelService dataStorageHotelService;

    private RepositoryHotelServiceCollection() {
        this.dataStorageHotelService = DataStorageHotelService.getDataStorageHotelService();
    }

    public static RepositoryHotelServiceCollection getRepositoryHotelService(){
        if(repositoryHotelService == null) {
            repositoryHotelService = new RepositoryHotelServiceCollection();
            System.out.println("Repository for Hotel's Services was created.");
        }
        return repositoryHotelService;
    }

    @Override
    public List<HotelService> readAll() {
        return dataStorageHotelService.getDataList();
    }

    @Override
    public boolean create(HotelService hotelService) {
        return dataStorageHotelService.getDataList().add(hotelService);
    }

    @Override
    public HotelService read(int index) {
        return dataStorageHotelService.getDataList().get(index);
    }

    @Override
    public boolean update(int index, HotelService hotelService) {
        dataStorageHotelService.getDataList().set(index, hotelService);
        return true;
    }

    @Override
    public boolean delete(int index) {
        dataStorageHotelService.getDataList().remove(index);
        return true;
    }

}
