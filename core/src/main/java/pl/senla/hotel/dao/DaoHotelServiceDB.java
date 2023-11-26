package pl.senla.hotel.dao;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.services.HotelService;

@AppComponent
public class DaoHotelServiceDB extends GenericDaoDB<HotelService> implements GenericDao<HotelService> {
}
