package pl.senla.hotel.repository;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.storage.DataStorageHotelService;

import java.util.List;

@AppComponent
public class RepositoryHotelServiceCollection implements Repository<HotelService> {

    @GetInstance(beanName = "DataStorageHotelService")
    private DataStorageHotelService dataStorageHotelService;

    public RepositoryHotelServiceCollection() {}

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
