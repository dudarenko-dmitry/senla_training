package pl.senla.hotel.controller;

import pl.senla.hotel.entity.facilities.HotelFacility;

public interface ControllerRoom extends ControllerCRUDALL<HotelFacility> {

    boolean updateRoomStatusAvailable(int idRoom);

    boolean updateRoomStatusRepaired(int idRoom);
}