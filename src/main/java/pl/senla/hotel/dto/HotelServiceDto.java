package pl.senla.hotel.dto;

import lombok.Builder;
import lombok.Data;
import pl.senla.hotel.entity.services.TypeOfService;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class HotelServiceDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 120L;

    private Integer idService;
    private OrderDto orderDto;
    private TypeOfService typeOfService;
    private GuestDto guestDto;
    private RoomDto room;
    private Integer numberOfDays;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private Integer cost;
//
//    @Override
//    public String toString() {
//        return "\nHotelService{" +
//                "idService=" + idService +
//                ", idOrder=" + order.getIdOrder() +
//                ", typeOfService=" + typeOfService +
//                ", Guest=" + guest.getIdGuest() +
//                ", Room=" + room.getIdRoom() + "," +
//                "\nnumberOfDays=" + numberOfDays +
//                ", checkInTime=" + checkInTime +
//                ", checkOutTime=" + checkOutTime +
//                ", cost=" + cost +
//                '}';
//    }
}
