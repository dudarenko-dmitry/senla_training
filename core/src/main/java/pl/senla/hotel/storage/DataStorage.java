package pl.senla.hotel.storage;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class DataStorage<T> {

    private final List<T> dataList = new ArrayList<>();

    @Override
    public String toString() {
        return "DataStorage{" +
                dataList + '}';
    }
}
