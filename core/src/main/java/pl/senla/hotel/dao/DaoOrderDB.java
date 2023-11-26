package pl.senla.hotel.dao;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.OrderDto;

@AppComponent
public class DaoOrderDB extends GenericDaoDB<OrderDto> implements GenericDao<OrderDto> {
}
