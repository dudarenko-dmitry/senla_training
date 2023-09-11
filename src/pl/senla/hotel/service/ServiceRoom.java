package pl.senla.hotel.service;

import pl.senla.hotel.entity.facilities.HotelFacility;

public interface ServiceRoom extends ServiceCRUDALL<HotelFacility>{

    boolean updateRoomStatusAvailable(int idRoom);

    boolean updateRoomStatusRepaired(int idRoom);
}
