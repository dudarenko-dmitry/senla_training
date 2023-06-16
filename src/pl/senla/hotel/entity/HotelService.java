package pl.senla.hotel.entity;

import java.time.LocalDate;

public abstract class HotelService {

    private int idHotelService;
    private LocalDate startDate;
    private Client client;

    public HotelService() {
    }

    public HotelService(int idHotelService) {
        this.idHotelService = idHotelService;
    }

    public HotelService(int idHotelService, LocalDate startDate) {
        this.idHotelService = idHotelService;
        this.startDate = startDate;
    }

    public HotelService(int idHotelService, LocalDate startDate, Client client) {
        if(client == null){
            System.out.println("Creating new order is not available without Client's data");
            // check if the Client exists in DB
            return;
        }
        this.idHotelService = idHotelService;
        this.startDate = startDate;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "idHotelService=" + idHotelService +
                ", startDay=" + startDate +
                client + '}';
    }
}
