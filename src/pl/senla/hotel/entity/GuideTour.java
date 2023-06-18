package pl.senla.hotel.entity;

import java.time.LocalDate;

public class GuideTour extends HotelService{

    private int idGuideTour;
    private String nameTour;
    private String transport;
    private int price;

    public GuideTour(int idGuideTour) {
        this.idGuideTour = idGuideTour;
    }

    public GuideTour(int idGuideTour, Guest guest, String nameTour, String transport, LocalDate startDate, int price) {
        super(startDate, guest);
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

    @Override
    public String toString() {
        return "\nGuideTour {" +
                "idGuideTour=" + idGuideTour + "," +
                super.getClient().toString() + "," +
                nameTour + "," +
                "\nStartDate=" + super.getStartDate().toString() +
                ", transport=" + transport +
                ", cost=" + price +
                '}';
    }
}
