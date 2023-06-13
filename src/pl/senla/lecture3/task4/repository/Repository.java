package pl.senla.lecture3.task4.repository;

import java.util.List;

public interface Repository<T> {

    List<T> readAll();
    boolean create(T t);
    T read(T t);
    boolean update(T t, T newT);
    boolean delete(T t);

}
