package pl.senla.lecture3.task4.entity;

import jdk.jfr.Timestamp;

public class GuideTour extends HotelService{

    private String nameTour;
    private String transport;

    public GuideTour() {
    }

    public GuideTour(String nameTour, String transport) {
        this.nameTour = nameTour;
        this.transport = transport;
    }

    public GuideTour(int idHotelService, String nameTour, String transport) {
        super(idHotelService);
        this.nameTour = nameTour;
        this.transport = transport;
    }

    public GuideTour(int idHotelService, Timestamp startTime, int priceService, String nameTour, String transport) {
        super(idHotelService, startTime, priceService);
        this.nameTour = nameTour;
        this.transport = transport;
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
        return "GuideTour{" +
                "nameTour='" + nameTour + '\'' +
                ", transport='" + transport + '\'' +
                '}';
    }
}
