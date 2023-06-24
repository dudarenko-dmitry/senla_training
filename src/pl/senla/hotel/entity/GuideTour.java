package pl.senla.hotel.entity;

import java.time.LocalDateTime;

public class GuideTour extends HotelService{

    private int idGuideTour;
    private LocalDateTime startDateTime;
    private String nameTour;
    private String transport;
    private int price;

    public GuideTour(int idGuideTour) {
        this.idGuideTour = idGuideTour;
    }

    public GuideTour(int idGuideTour, Guest guest, String nameTour, String transport, LocalDateTime startDateTime, int price) {
        super("GuideTour", guest);
        this.startDateTime = startDateTime;
        this.idGuideTour = idGuideTour;
        this.nameTour = nameTour;
        this.transport = transport;
        this.price = price;
    }

    public int getIdGuideTour() {
        return idGuideTour;
    }

    public void setIdGuideTour(int idGuideTour) {
        this.idGuideTour = idGuideTour;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Override
    public String toString() {
        return "\nGuideTour{" +
                "typeOfService=" + super.getTypeOfService() +
                ", idGuideTour=" + idGuideTour + "," +
                super.getGuest().toString() + "," +
                nameTour + "," +
                "\nStartTime=" + startDateTime +
                ", transport=" + transport +
                ", cost=" + price +
                '}';
    }
}
