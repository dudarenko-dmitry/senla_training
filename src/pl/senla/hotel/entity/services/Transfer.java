package pl.senla.hotel.entity.services;

import java.time.LocalDateTime;

public class Transfer extends HotelService{

    private LocalDateTime startDateTime;
    private String nameTour;
    private String transport;
    private int price;

    public Transfer(int idService, int idOrder, int idGuest, String nameTour, String transport, LocalDateTime startDateTime, int price) {
        super(idService, idOrder, TypeOfService.TRANSFER.getTypeName(), idGuest);
        this.startDateTime = startDateTime;
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
        return "\nTransfer{" +
                "idOrder= " + super.getIdOrder() +
                ", typeOfService=" + super.getTypeOfService() +
                "\n idTransfer=" + super.getIdService() + "," +
                ", idGuest=" + super.getIdGuest() + "," +
                ", Route's name=" + nameTour + "," +
                "\nStartTime=" + startDateTime +
                ", transport=" + transport +
                ", cost=" + price +
                '}';
    }
}
