package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.repository.RepositoryRoom;
import pl.senla.hotel.repository.RepositoryRoomCollection;

import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.RoomConstant.*;

public class ServiceRoomImpl implements ServiceRoom {

    private final RepositoryRoom roomRepository;

    public ServiceRoomImpl() {
        this.roomRepository = new RepositoryRoomCollection();
    }

    @Override
    public List<Room> readAll() {
        if(roomRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM);
        }
        return roomRepository.readAll();
    }

    @Override
    public boolean create(String roomString) {
        String[] roomData = roomString.split(":");
        Room room = new Room();
        room.setIdFacility(-1);
        room.setCategory(roomData[0]);
        room.setNameFacility(roomData[1]);
        room.setPrice(Integer.parseInt(roomData[2]));
        room.setCapacity(Integer.parseInt(roomData[3]));
        room.setRoomLevel(roomData[4]);
        room.setRoomStatus(roomData[5]);
        setIdRoomNew(room);
        return roomRepository.create(room);
    }

//    public Room(String category,
//    String nameFacility,
//    int price,
//    int capacity,
//    String roomLevel,
//    String roomStatus)
    @Override
    public Room read(int id) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM);
            return null;
        } else if(roomRepository.read(id) == null){
            System.out.println(ERROR_READ_ROOM);
        }
        return roomRepository.read(id);
    }

    @Override
    public boolean update(int idRoom, String roomString) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM);
            return false;
        } else if(read(idRoom) == null){
            System.out.println(ERROR_READ_ROOM);
            return false;
        }
        String[] roomData = roomString.split(":");
        Room roomUpdate = new Room();
        roomUpdate.setIdFacility(idRoom);
        roomUpdate.setCategory(roomData[0]);
        roomUpdate.setNameFacility(roomData[1]);
        roomUpdate.setPrice(Integer.parseInt(roomData[2]));
        roomUpdate.setCapacity(Integer.parseInt(roomData[3]));
        roomUpdate.setRoomLevel(roomData[4]);
        roomUpdate.setRoomStatus(roomData[5]);
        return roomRepository.update(roomUpdate);
    }

    @Override
    public boolean delete(int id) {
        if(readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM);
            return false;
        } else if(read(id) == null){
            System.out.println(ERROR_READ_ROOM);
            return false;
        }
        return roomRepository.delete(id);
    }

    @Override
    public List<Room> readAllRoomsSortByPrice() {
        return roomRepository.readAllRoomsSortByPrice();
    }

    @Override
    public List<Room> readAllRoomsSortByCapacity() {
        return roomRepository.readAllRoomsSortByCapacity();
    }

    @Override
    public List<Room> readAllRoomsSortByLevel() {
        return roomRepository.readAllRoomsSortByLevel();
    }

    private void setIdRoomNew(Room room) {
        int lastId = readAll()
                .stream()
                .map(Room::getIdFacility)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);
        room.setIdFacility(lastId + 1);
    }
}
