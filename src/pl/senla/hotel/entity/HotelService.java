package pl.senla.hotel.entity;

import java.time.LocalDate;

import static pl.senla.hotel.constant.RoomReservationConstant.ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT;

public abstract class HotelService {

    private int idHotelService;
    private LocalDate startDate;
    private Guest guest;

    public HotelService() {
    }

    public HotelService(int idHotelService) {
        this.idHotelService = idHotelService;
    }

    public HotelService(int idHotelService, LocalDate startDate) {
        this.idHotelService = idHotelService;
        this.startDate = startDate;
    }

    public HotelService(int idHotelService, LocalDate startDate, Guest guest) {
        if(guest == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return;
        }
        this.idHotelService = idHotelService;
        this.startDate = startDate;
        this.guest = guest;
    }

    public int getIdHotelService() {
        return idHotelService;
    }

    public void setIdHotelService(int idHotelService) {
        this.idHotelService = idHotelService;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Guest getClient() {
        return guest;
    }

    public void setClient(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "idHotelService=" + idHotelService +
                ", startDay=" + startDate +
                guest + '}';
    }
}
