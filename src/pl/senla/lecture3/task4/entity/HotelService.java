package pl.senla.lecture3.task4.entity;

import jdk.jfr.Timestamp;

public abstract class HotelService {

    private int idHotelService;
    private Timestamp startTime;
    private int priceService;

    public HotelService() {
    }

    public HotelService(int idHotelService) {
        this.idHotelService = idHotelService;
    }

    public HotelService(int idHotelService, Timestamp startTime, int priceService) {
        this.idHotelService = idHotelService;
        this.startTime = startTime;
        this.priceService = priceService;
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

    @Override
    public String toString() {
        return "HotelService{" +
                "idHotelService=" + idHotelService +
                ", startTime=" + startTime +
                ", priceService=" + priceService +
                '}';
    }
}
