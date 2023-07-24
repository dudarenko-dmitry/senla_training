package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.repository.RepositoryFacility;
import pl.senla.hotel.repository.RepositoryFacilityCollection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.HotelFacilityConstant.*;

public class ServiceFacilityImpl implements ServiceFacility{

    private final RepositoryFacility repositoryHotelFacility;

    public ServiceFacilityImpl() {
        this.repositoryHotelFacility = RepositoryFacilityCollection.getRepositoryFacility();
    }

    @Override
    public List<HotelFacility> readAll() {
        if(repositoryHotelFacility.readAll() == null || repositoryHotelFacility.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_HOTEL_FACILITY);
            return Collections.emptyList();
        }
        return repositoryHotelFacility.readAll();
    }

    @Override
    public boolean create(String hotelFacilityString) {
        String[] facilityData = hotelFacilityString.split(";");
        Room hotelFacility = new Room();
        hotelFacility.setIdFacility(-1);
        hotelFacility.setCategory(facilityData[0]);
        hotelFacility.setNameFacility(facilityData[1]);
        hotelFacility.setPrice(Integer.parseInt(facilityData[2]));
        hotelFacility.setCapacity(Integer.parseInt(facilityData[3]));
        hotelFacility.setRoomLevel(facilityData[4]);
        hotelFacility.setRoomStatus(facilityData[5]);
        setIdFacilityNew(hotelFacility);
        return repositoryHotelFacility.create(hotelFacility);
    }

    @Override
    public HotelFacility read(int idFacility) {
        if(repositoryHotelFacility.readAll() == null || repositoryHotelFacility.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_HOTEL_FACILITY);
            return null;
        }
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdFacility() == idFacility){
                return repositoryHotelFacility.read(idFacility);
            }
        }
        System.out.println(ERROR_READ_HOTEL_FACILITY);
        return null;
    }

    @Override
    public boolean update(int idFacility, String hotelFacilityString) {
        if(repositoryHotelFacility.readAll() == null || repositoryHotelFacility.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ROOM);
            return false;
        } else if(read(idFacility) == null){
            System.out.println(ERROR_READ_ROOM);
            return false;
        }
        HotelFacility hotelFacilityUpdate = read(idFacility);
        hotelFacilityUpdate.setPrice(Integer.parseInt(hotelFacilityString));
        return repositoryHotelFacility.update(idFacility, hotelFacilityUpdate);
    }

    @Override
    public boolean delete(int idFacility) {
        if(repositoryHotelFacility.readAll() == null || repositoryHotelFacility.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_HOTEL_FACILITY);
        }
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdFacility() == idFacility){
                return repositoryHotelFacility.delete(idFacility);
            }
        }
        System.out.println(ERROR_READ_HOTEL_FACILITY);
        return false;
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByCategory() {
        return repositoryHotelFacility.readPriceListForServicesSortByCategory();
    }

    @Override
    public List<HotelFacility> readPriceListForServicesSortByPrice() {
        return repositoryHotelFacility.readPriceListForServicesSortByPrice();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByPrice() {
        return repositoryHotelFacility.readAllRoomsSortByPrice();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByCapacity() {
        return repositoryHotelFacility.readAllRoomsSortByCapacity();
    }

    @Override
    public List<HotelFacility> readAllRoomsSortByLevel() {
        return repositoryHotelFacility.readAllRoomsSortByLevel();
    }

    private void setIdFacilityNew(HotelFacility hotelFacility) {
        int lastId = readAll()
                .stream()
                .map(HotelFacility::getIdFacility)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        hotelFacility.setIdFacility(lastId + 1);
    }
}
