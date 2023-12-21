package pl.senla.hotel.dto;

import lombok.Builder;
import lombok.Data;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.RoomLevel;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class RoomDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private CategoryFacility category;
    private String nameFacility;
    private Integer price;
    private Integer capacity;
    private RoomLevel roomLevel;

//    @Override
//    public String toString() {
//        return "\nHotelFacility{" +
//                "idFacility=" + idRoom +
//                ", category='" + category + '\'' +
//                ", nameFacility=" + nameFacility +
//                ", price=" + price +
//                ", capacity=" + capacity +
//                ", roomLevel=" + roomLevel +
//                ", roomStatus=" + roomStatus +
//                '}';
//    }
}
