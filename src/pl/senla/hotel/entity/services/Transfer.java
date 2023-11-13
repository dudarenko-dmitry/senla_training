//package pl.senla.hotel.entity.services;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Setter
//@Getter
//public class Transfer extends HotelService{
//
//    private LocalDateTime startDateTime;
//    private String nameTour;
//    private String transport;
//    private Integer price;
//
//    public Transfer(Integer idService, Integer idOrder, Integer idGuest, String nameTour, String transport,
//                    LocalDateTime startDateTime, Integer price) {
//        super(idService, idOrder, TypeOfService.TRANSFER, idGuest);
//        if (nameTour == null) {
//            // add ERROR_message
//            return;
//        }
//        if (startDateTime == null) {
//            // add ERROR_message
//            return;
//        }
//        if (price == null) {
//            // add ERROR_message
//            return;
//        }
//        this.startDateTime = startDateTime;
//        this.nameTour = nameTour;
//        this.transport = transport;
//        this.price = price;
//    }
//
//    public String getNameTour() {
//        return nameTour;
//    }
//
//    public void setNameTour(String nameTour) {
//        this.nameTour = nameTour;
//    }
//
//    public String getTransport() {
//        return transport;
//    }
//
//    public void setTransport(String transport) {
//        this.transport = transport;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public LocalDateTime getStartDateTime() {
//        return startDateTime;
//    }
//
//    public void setStartDateTime(LocalDateTime startDateTime) {
//        this.startDateTime = startDateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "\nTransfer{" +
//                "idOrder= " + super.getIdOrder() +
//                ", typeOfService=" + super.getTypeOfService() +
//                "\n idTransfer=" + super.getIdService() + "," +
//                ", idGuest=" + super.getIdGuest() + "," +
//                ", Route's name=" + nameTour + "," +
//                "\nStartTime=" + startDateTime +
//                ", transport=" + transport +
//                ", cost=" + price +
//                '}';
//    }
//}
