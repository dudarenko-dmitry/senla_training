package pl.senla.hotel.entity.services;

import static pl.senla.hotel.constant.RoomReservationConstant.ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT;

public abstract class HotelService {

    protected String typeOfService;
    protected int idGuest;

    protected HotelService() {
    }

    protected HotelService(String typeOfService, int idGuest) {
        if (idGuest == -1) {
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return;
        }
        this.idGuest = idGuest;
        this.typeOfService = typeOfService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    @Override
    public String toString() {
        return "{typeOfService='" + typeOfService +
                ", idGuest=" + idGuest +
                '}';
    }

}
