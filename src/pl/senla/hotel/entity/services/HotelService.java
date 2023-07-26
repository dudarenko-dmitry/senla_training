package pl.senla.hotel.entity.services;

import static pl.senla.hotel.constant.OrderConstant.ERROR_READ_ORDER;
import static pl.senla.hotel.constant.RoomReservationConstant.ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT;

public abstract class HotelService {

    protected int idService = -1;
    protected int idOrder;
    protected String typeOfService;
    protected int idGuest;

    protected HotelService() {
    }

    protected HotelService(int idService, int idOrder, String typeOfService, int idGuest) {
        if(idOrder < 0) {
            System.out.println(ERROR_READ_ORDER);
            return;
        }
        if (idGuest < 0) {
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return;
        }
        this.idService = idService;
        this.idGuest = idGuest;
        this.typeOfService = typeOfService;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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
