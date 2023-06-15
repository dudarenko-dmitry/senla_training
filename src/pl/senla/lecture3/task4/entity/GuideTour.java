package pl.senla.lecture3.task4.entity;

import java.time.LocalDate;

public class GuideTour extends HotelService{

    private String nameTour;
    private String transport;
    private int price;

    public GuideTour(String nameTour, String transport, int price) {
        this.nameTour = nameTour;
        this.transport = transport;
        this.price = price;
    }

    public GuideTour(int idHotelService, String nameTour, String transport, int price) {
        super(idHotelService);
        this.nameTour = nameTour;
        this.transport = transport;
        this.price = price;
    }

    public GuideTour(int idHotelService, LocalDate startDate, String nameTour, String transport, int price) {
        super(idHotelService, startDate);
        this.nameTour = nameTour;
        this.transport = transport;
        this.price = price;
    }

    public GuideTour(int idHotelService, LocalDate startDate, Client client, String nameTour, String transport, int price) {
        super(idHotelService, startDate, client);
        this.nameTour = nameTour;
        this.transport = transport;
        this.price = price;
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

    @Override
    public String toString() {
        return "GuideTour{" + super.toString() +
                "nameTour='" + nameTour + '\'' +
                ", transport='" + transport +
                ", price='" +  price + '\'' +
                '}';
    }
}
