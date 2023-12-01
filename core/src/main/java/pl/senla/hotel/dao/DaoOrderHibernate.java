package pl.senla.hotel.dao;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.entity.Order;

@AppComponent
public class DaoOrderHibernate extends GenericDaoHibernate<Order> implements GenericDao<Order> {
}
