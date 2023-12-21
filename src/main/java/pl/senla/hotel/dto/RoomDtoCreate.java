//package pl.senla.hotel.dto;
//
//import lombok.Builder;
//import lombok.Data;
//import pl.senla.hotel.entity.facilities.CategoryFacility;
//import pl.senla.hotel.entity.facilities.RoomLevel;
//import pl.senla.hotel.entity.facilities.RoomStatus;
//
//import java.io.Serial;
//import java.io.Serializable;
//
//@Data
//@Builder
//public class RoomDtoCreate implements Serializable {
//
//    @Serial
//    private static final long serialVersionUID = 4L;
//
//    private CategoryFacility category;
//    private String nameFacility;
//    private Integer price;
//    private Integer capacity;
//    private RoomLevel roomLevel;
//    private RoomStatus roomStatus;
//
//    @Override
//    public String toString() {
//        return "\nHotelFacility{" +
//                ", category='" + category + '\'' +
//                ", nameFacility=" + nameFacility +
//                ", price=" + price +
//                ", capacity=" + capacity +
//                ", roomLevel=" + roomLevel +
//                ", roomStatus=" + roomStatus +
//                '}';
//    }
//}
