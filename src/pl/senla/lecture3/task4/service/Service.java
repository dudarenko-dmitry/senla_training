package pl.senla.lecture3.task4.service;

import java.util.List;

public interface Service<T> {

    List<T> readAll();
    boolean create(T t);
    T read(int id);
    boolean update(T t);
    boolean delete(int id);

}
