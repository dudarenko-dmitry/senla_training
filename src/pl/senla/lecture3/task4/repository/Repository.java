package pl.senla.lecture3.task4.repository;

import java.util.List;

public interface Repository<T> {

    List<T> readAll();
    boolean create(T t);
    T read(int id);
    boolean update(T t);
    boolean delete(int id);

}
