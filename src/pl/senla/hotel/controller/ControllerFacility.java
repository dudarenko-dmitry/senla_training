package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.HotelFacility;

import java.util.List;

public interface ControllerFacility extends ControllerCRUDALL<HotelFacility> {

    List<HotelFacility> readPriceListForServicesSortByCategory();
    List<HotelFacility> readPriceListForServicesSortByPrice();
}
