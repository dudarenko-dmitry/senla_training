package pl.senla.hotel.dao;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.Guest;

@AppComponent
public class DaoGuestDB extends GenericDaoDB<Guest> implements GenericDao<Guest> {
}
