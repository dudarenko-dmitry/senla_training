package pl.senla.hotel.dao;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.services.RoomReservation;

@AppComponent
public class DaoRoomReservationDB extends GenericDaoDB<RoomReservation> implements GenericDao<RoomReservation> {
}
