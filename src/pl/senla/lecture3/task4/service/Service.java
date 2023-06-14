package pl.senla.lecture3.task4.service;

import java.util.List;

public interface Service<T> {

    List<T> readAll();
    boolean create(T newClient);
    T read(T t);
    boolean update(T t);
    boolean delete(T t);

}
