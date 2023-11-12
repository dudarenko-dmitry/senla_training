package pl.senla.hotel.dao;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.facilities.Room;

@AppComponent
public class DaoRoomDB extends GenericDaoDB<Room> implements GenericDao<Room> {
}
