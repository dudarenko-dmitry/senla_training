package pl.senla.hotel.entity;

import java.time.LocalDate;

import static pl.senla.hotel.constant.RoomReservationConstant.ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT;

public abstract class HotelService {

    private LocalDate startDate;
    private Guest guest;

    public HotelService() {
    }

    public HotelService(LocalDate startDate) {
        this.startDate = startDate;
    }

    public HotelService(LocalDate startDate, Guest guest) {
        if(guest == null){
            System.out.println(ERROR_CREATE_ROOM_RESERVATION_NO_CLIENT);
            return;
        }
        this.startDate = startDate;
        this.guest = guest;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "startDay=" + startDate +
                guest + '}';
    }
}
