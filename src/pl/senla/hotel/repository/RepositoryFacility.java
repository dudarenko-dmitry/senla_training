package pl.senla.hotel.repository;

import pl.senla.hotel.entity.facilities.HotelFacility;

import java.util.List;

public interface RepositoryFacility extends RepositoryCRUDALL<HotelFacility> {

    List<HotelFacility> readPriceListForServicesSortByCategory();
    List<HotelFacility> readPriceListForServicesSortByPrice();

}
