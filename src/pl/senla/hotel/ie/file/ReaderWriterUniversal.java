package pl.senla.hotel.ie.file;

import java.io.IOException;
import java.util.List;

public interface ReaderWriterUniversal {

    List<?> load(Class<?> clazz) throws IOException;
    void save(List<?> list) throws IOException;
}
