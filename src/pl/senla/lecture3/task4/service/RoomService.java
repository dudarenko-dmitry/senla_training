package pl.senla.lecture3.task4.service;

import pl.senla.lecture3.task4.entity.Room;
import pl.senla.lecture3.task4.repository.Repository;
import pl.senla.lecture3.task4.repository.RoomRepositoryCollection;

import java.util.List;

import static pl.senla.lecture3.task4.constant.RoomConstant.*;

public class RoomService implements Service<Room> {

    private Repository<Room> roomRepository = new RoomRepositoryCollection();

    public RoomService() {
    }

    public RoomService(Repository<Room> roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> readAll() {
        if(roomRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM);
        }
        return roomRepository.readAll();
    }

    @Override
    public boolean create(Room room) {
        if(roomRepository.read(room) != null) {
            System.out.println(ERROR_CREATE_ROOM);
            return false;
        }
        return roomRepository.create(room);
    }

    @Override
    public Room read(Room room) {
        if(roomRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM);
        } else if(roomRepository.read(room) == null){
            System.out.println(ERROR_READ_ROOM);
        }
        return roomRepository.read(room);
    }

    @Override
    public boolean update(Room room) {
        if(roomRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM);
            return false;
        } else if(roomRepository.read(room) == null){
            System.out.println(ERROR_READ_ROOM);
            return false;
        }
        return roomRepository.update(room);
    }

    @Override
    public boolean delete(Room room) {
        if(roomRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_ROOM);
            return false;
        } else if(roomRepository.read(room) == null){
            System.out.println(ERROR_READ_ROOM);
            return false;
        }
        return roomRepository.delete(room);
    }
}
