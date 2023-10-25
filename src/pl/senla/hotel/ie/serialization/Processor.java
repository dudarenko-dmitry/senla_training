package pl.senla.hotel.ie.serialization;

import pl.senla.hotel.entity.Hotel;

public interface Processor {

    Hotel loadHotel();
    void saveHotel(Hotel hotel);
}
