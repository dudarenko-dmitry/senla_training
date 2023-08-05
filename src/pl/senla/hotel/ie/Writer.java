package pl.senla.hotel.ie;

import java.io.IOException;
import java.util.List;

public interface Writer<T> {

    void save(List<T> t) throws IOException;
}
