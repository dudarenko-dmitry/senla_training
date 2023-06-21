package pl.senla.hotel.entity;

import static pl.senla.hotel.constant.RoomReservationConstant.ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT;

public abstract class HotelService {

    private Guest guest;

    public HotelService() {
    }

    public HotelService(Guest guest) {
        if(guest == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return;
        }
        this.guest = guest;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "{" + guest + '}';
    }
}
