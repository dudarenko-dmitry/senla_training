package pl.senla.hotel.entity.services;

import pl.senla.hotel.entity.Guest;

import static pl.senla.hotel.constant.RoomReservationConstant.ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT;

public abstract class HotelService {

    private String typeOfService;
    private Guest guest;

    protected HotelService() {
    }

    protected HotelService(String typeOfService, Guest guest) {
        if(guest == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return;
        }
        this.guest = guest;
        this.typeOfService=typeOfService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return  "{typeOfService='" + typeOfService + '\'' +
                ", guest=" + guest +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "{" + guest + '}';
//    }
}
