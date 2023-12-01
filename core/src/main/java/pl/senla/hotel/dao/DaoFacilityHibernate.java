package pl.senla.hotel.dao;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.facilities.Room;

@AppComponent
public class DaoFacilityHibernate extends GenericDaoHibernate<Room> implements GenericDao<Room> {

}
