package pl.senla.hotel.ie.file;

import java.io.IOException;
import java.util.List;

public interface ReaderWriterUniversal<T> {

    List<T> load(Class<T> clazz) throws IOException;
    void save(List<T> list) throws IOException;
}
