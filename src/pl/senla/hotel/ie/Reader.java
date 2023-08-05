package pl.senla.hotel.ie;

import java.io.IOException;
import java.util.List;

public interface Reader<T> {

    List<T> load() throws IOException, ClassNotFoundException;
}
