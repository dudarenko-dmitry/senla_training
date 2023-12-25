package pl.senla.hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class HotelServiceDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 120L;

    private Integer idOrder;
    private Integer idGuest;
    private Integer idHotelFacility;
    private Integer numberOfDays;
    private String checkInTimeString;
    private String checkOutTimeString;
    private Integer cost;

    @Override
    public String toString() {
        return "\nHotelService{" +
                "Order=" + idOrder +
                ", Guest=" + idGuest +
                ", Room=" + idHotelFacility + "," +
                "\nnumberOfDays=" + numberOfDays +
                ", checkInTime=" + checkInTimeString +
                ", checkOutTime=" + checkOutTimeString +
                ", cost=" + cost +
                '}';
    }
}
