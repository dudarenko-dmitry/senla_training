package pl.senla.hotel.comparators;

import pl.senla.hotel.entity.facilities.HotelFacility;

import java.util.Comparator;

public class HotelFacilityComparatorByPrice implements Comparator<HotelFacility> {

    @Override
    public int compare(HotelFacility o1, HotelFacility o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
