package pl.senla.hotel.repository;

import pl.senla.hotel.comparators.*;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageFacility;

import java.util.List;

public class RepositoryFacilityCollection implements RepositoryFacility{

    private final DataStorage<HotelFacility> priceList;

    public RepositoryFacilityCollection() {
        this.priceList = DataStorageFacility.getDataStorageFacility();
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

    @Override
    public List<HotelFacility> readAllRoomsSortByPrice() {
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM.getTypeName()))
                .sorted(new RoomComparatorByPrice())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByCapacity() {
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM.getTypeName()))
                .sorted(new RoomComparatorByCapacity())
                .toList();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByLevel() {
        return readAll().stream()
                .filter(o -> o.getCategory().equals(CategoryFacility.ROOM.getTypeName()))
                .sorted(new RoomComparatorByLevel())
                .toList();
    }
}
