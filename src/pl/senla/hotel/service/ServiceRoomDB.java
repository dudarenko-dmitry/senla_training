package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.facilities.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;
import static pl.senla.hotel.constant.HotelFacilityConstant.*;

@AppComponent
public class ServiceRoomDB implements ServiceRoom {

    @GetInstance(beanName = "DaoFacilityDB")
    private GenericDao<HotelFacility> daoFacility;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "change-room-status.enabled", type = "Boolean")
    private Boolean changeRoomStatusEnabled;

    public ServiceRoomDB() {}

    @Override
    public List<HotelFacility> readAll() { // List<Room> ???
        return daoFacility.readAll() // daoRoom кастим к HotelFacility
                .stream()
                .filter(r -> r.getCategory().equals(CategoryFacility.ROOM))
                .toList();
    }

    @Override
    public boolean create(String roomString) {
        String[] roomData = roomString.split(";");
        Room room = new Room();
        room.setCategory(CategoryFacility.valueOf(roomData[0]));
        room.setNameFacility(roomData[1]);
        room.setPrice(Integer.parseInt(roomData[2]));
        room.setCapacity(Integer.parseInt(roomData[3]));
        room.setRoomLevel(RoomLevel.valueOf(roomData[4]));
        room.setRoomStatus(RoomStatus.valueOf(roomData[5]));
        setIdRoomNew(room);
        return daoFacility.create(room);
    }

    @Override
    public Room read(int idRoom) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if (daoFacility.read(idRoom) != null) {
            return (Room) daoFacility.read(idRoom);
        }
        System.out.println(ERROR_INPUT);
        return null;
    }

    @Override
    public boolean update(int idRoom, String roomString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (read(idRoom) != null) {
            Room roomUpdate = read(idRoom);
            roomUpdate.setPrice(Integer.parseInt(roomString));
            return daoFacility.update(idRoom, roomUpdate);
        }
        System.out.println(READ_ALL_ROOM_IS_EMPTY);
        return false;
    }

    @Override
    public boolean updateRoomStatusAvailable(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (changeRoomStatusEnabled){
            if (read(idRoom) != null) {
                Room roomUpdate = read(idRoom);
                roomUpdate.makeRoomAvailable();
                return daoFacility.update(idRoom, roomUpdate);
            }
            System.out.println(ROOM_NOT_EXIST);
            return false;
        }
        System.out.println(ERROR_NO_PERMISSION);
        return false;
    }

    @Override
    public boolean updateRoomStatusRepaired(int idRoom) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (changeRoomStatusEnabled){
            if (read(idRoom) != null) {
                Room roomUpdate = read(idRoom);
                roomUpdate.makeRoomRepaired();
                return daoFacility.update(idRoom, roomUpdate);
            }
            System.out.println(ROOM_NOT_EXIST);
            return false;
        }
        System.out.println(ERROR_NO_PERMISSION);
        return false;
    }

    @Override
    public boolean delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if (read(id) != null) {
            return daoFacility.delete(id);
        }
        System.out.println(ROOM_NOT_EXIST);
        return false;
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
