package pl.senla.lecture3.task4.controller;

import java.util.List;

public interface Controller<T> {

    List<T> readAll();
    boolean create(T t);
    T read(T t);
    boolean update(T t, T newT);
    boolean delete(T t);

}
