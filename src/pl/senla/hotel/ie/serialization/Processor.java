package pl.senla.hotel.ie.serialization;

import pl.senla.hotel.entity.SavedHotel;

public interface Processor {

    SavedHotel loadHotel();
    void saveHotel(SavedHotel hotel);
}
