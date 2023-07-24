package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.repository.RepositoryFacility;
import pl.senla.hotel.repository.RepositoryFacilityCollection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.HotelFacilityConstant.*;

public class ServiceRoomImpl implements ServiceRoom {

    private final RepositoryFacility repositoryFacility;

    public ServiceRoomImpl() {
        this.repositoryFacility = RepositoryFacilityCollection.getRepositoryFacility();
    }

    @Override
    public List<HotelFacility> readAll() {
        if(repositoryFacility.readAll() == null || repositoryFacility.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ROOM);
            return Collections.emptyList();
        }
        return repositoryFacility.readAll()
                .stream()
                .filter(r -> r.getCategory().equals(CategoryFacility.ROOM.getTypeName()))
                .toList();
    }

    @Override
    public boolean create(String roomString) {
        String[] roomData = roomString.split(";");
        Room room = new Room();
        room.setIdFacility(-1);
        room.setCategory(roomData[0]);
        room.setNameFacility(roomData[1]);
        room.setPrice(Integer.parseInt(roomData[2]));
        room.setCapacity(Integer.parseInt(roomData[3]));
        room.setRoomLevel(roomData[4]);
        room.setRoomStatus(roomData[5]);
        setIdRoomNew(room);
        return repositoryFacility.create(room);
    }

    @Override
    public Room read(int idRoom) {
        if(repositoryFacility.readAll() == null || repositoryFacility.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ROOM);
            return null;
        } else if (idRoom < 0 || idRoom > readAll().size()){
            System.out.println(ERROR_INPUT);
            return null;
        }
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdFacility() == idRoom){
                return (Room) repositoryFacility.read(idRoom);
            }
        }
        System.out.println(ERROR_READ_ROOM);
        return null;
    }

    @Override
    public boolean update(int idRoom, String roomString) {
        if(repositoryFacility.readAll() == null || repositoryFacility.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ROOM);
            return false;
        } else if(read(idRoom) == null){
            System.out.println(ERROR_READ_ROOM);
            return false;
        }
        Room roomUpdate = read(idRoom);
        roomUpdate.setPrice(Integer.parseInt(roomString));
        return repositoryFacility.update(idRoom, roomUpdate);
    }

    @Override
    public boolean delete(int id) {
        if(repositoryFacility.readAll() == null || repositoryFacility.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_ROOM);
            return false;
        } else if(read(id) == null){
            System.out.println(ERROR_READ_ROOM);
            return false;
        }
        return repositoryFacility.delete(id);
    }

    private void setIdRoomNew(HotelFacility room) {
        int lastId = readAll()
                .stream()
                .map(HotelFacility::getIdFacility)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        room.setIdFacility(lastId + 1);
    }
}
