package pl.senla.hotel.storage;

import java.util.ArrayList;
import java.util.List;

public abstract class DataStorage<T> {

    private List<T> dataList = new ArrayList<>();

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "DataStorage{" +
                dataList + '}';
    }
}
