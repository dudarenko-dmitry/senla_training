package pl.senla.hotel.service;

import pl.senla.hotel.entity.RoomReservation;

public interface ServiceRoomReservation extends ServiceCRUDALL<RoomReservation>, ServiceRoomReservationAdditional,
        ServiceFreeRoomCRUDALL, ServiceFreeRoomAdditional {
}
