package pl.senla.hotel.service;

import pl.senla.hotel.constant.RoomConstant;
import pl.senla.hotel.entity.Room;
import pl.senla.hotel.repository.RepositoryRoom;
import pl.senla.hotel.repository.RepositoryRoomCollection;

import java.util.List;

public class RoomService implements ServiceRoom {

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
        if(roomRepository.read(room.getRoomId()) != null) {
            System.out.println(RoomConstant.ERROR_CREATE_ROOM);
            return false;
        }
        return roomRepository.create(room);
    }

    @Override
    public Room read(int id) {
        if(roomRepository.readAll() == null){
            System.out.println(RoomConstant.ERROR_READ_ALL_ROOM);
            return null;
        } else if(roomRepository.read(id) == null){
            System.out.println(RoomConstant.ERROR_READ_ROOM);
            return null;
        }
        return roomRepository.read(id);
    }

    @Override
    public boolean update(Room room) {
        if(roomRepository.readAll() == null){
            System.out.println(RoomConstant.ERROR_READ_ALL_ROOM);
            return false;
        } else if(roomRepository.read(room.getRoomId()) == null){
            System.out.println(RoomConstant.ERROR_READ_ROOM);
            return false;
        }
        return roomRepository.update(room);
    }

    @Override
    public boolean delete(int id) {
        if(roomRepository.readAll() == null){
            System.out.println(RoomConstant.ERROR_READ_ALL_ROOM);
            return false;
        } else if(roomRepository.read(id) == null){
            System.out.println(RoomConstant.ERROR_READ_ROOM);
            return false;
        }
        return roomRepository.delete(id);
    }
}
