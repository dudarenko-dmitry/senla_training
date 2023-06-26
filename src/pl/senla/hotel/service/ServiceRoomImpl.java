package pl.senla.hotel.service;

import pl.senla.hotel.constant.RoomConstant;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.FreeRoom;
import pl.senla.hotel.repository.RepositoryRoom;
import pl.senla.hotel.repository.RepositoryRoomCollection;

import java.util.List;

public class ServiceRoomImpl implements ServiceRoom {

    private final RepositoryRoom roomRepository = new RepositoryRoomCollection();

    @Override
    public List<Room> readAll() {
        if(roomRepository.readAll() == null){
            System.out.println(RoomConstant.ERROR_READ_ALL_ROOM);
        }
        return roomRepository.readAll();
    }

    @Override
    public boolean create(Room room) {
        if(read(room.getIdFacility()) != null &&
                read(room.getIdFacility()).equals(room)) {
            System.out.println(RoomConstant.ERROR_CREATE_ROOM);
            return false;
        }
        setIdRoomNew(room);
        return roomRepository.create(room);
    }

    @Override
    public Room read(int id) {
        if(readAll() == null){
            System.out.println(RoomConstant.ERROR_READ_ALL_ROOM);
            return null;
        }
        return roomRepository.read(id);
    }

    @Override
    public boolean update(Room room) {
        if(readAll() == null){
            System.out.println(RoomConstant.ERROR_READ_ALL_ROOM);
            return false;
        } else if(read(room.getIdFacility()) == null){
            System.out.println(RoomConstant.ERROR_READ_ROOM);
            return false;
        }
        return roomRepository.update(room);
    }

    @Override
    public boolean delete(int id) {
        if(readAll() == null){
            System.out.println(RoomConstant.ERROR_READ_ALL_ROOM);
            return false;
        } else if(read(id) == null){
            System.out.println(RoomConstant.ERROR_READ_ROOM);
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
                .max((o1, o2) -> o1 - o2)
                .orElse(-1);
        room.setIdFacility(lastId + 1);
    }
}
