package pl.senla.hotel.dao;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.facilities.HotelFacility;

@AppComponent
public class DaoFacilityHibernate extends GenericDaoHibernate<HotelFacility> implements GenericDao<HotelFacility> {

}
