package pl.senla.lecture3.task4.entity;

import jdk.jfr.Timestamp;

public abstract class HotelService {

    private int idHotelService;
    private Timestamp startTime;
    private int priceService;
    private Client client;

    public HotelService() {
    }

    public HotelService(int idHotelService) {
        this.idHotelService = idHotelService;
    }

    public HotelService(Client client) {
        this.client = client;
    }

    public HotelService(int idHotelService, Timestamp startTime, int priceService, Client client) {
        this.idHotelService = idHotelService;
        this.startTime = startTime;
        this.priceService = priceService;
        this.client = client;
    }

    public int getIdHotelService() {
        return idHotelService;
    }

    public void setIdHotelService(int idHotelService) {
        this.idHotelService = idHotelService;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public int getPriceService() {
        return priceService;
    }

    public void setPriceService(int priceService) {
        this.priceService = priceService;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "HotelService{" +
                "idHotelService=" + idHotelService +
                ", startTime=" + startTime +
                ", priceService=" + priceService +
                ", clientID=" + client.getIdClient() +
                '}';
    }
}
