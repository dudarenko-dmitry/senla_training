package pl.senla.hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class HotelServiceCreateDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 120L;

    private Integer idOrder;
    private Integer idGuest;
    private Integer idHotelFacility;
    private Integer numberOfDays;
    private String checkInTimeString;

    @Override
    public String toString() {
        return "\nHotelService{" +
                "idOrder=" + idOrder +
                ", idGuest=" + idGuest +
                ", idRoom=" + idHotelFacility + "," +
                "\nnumberOfDays=" + numberOfDays +
                ", checkInTime=" + checkInTimeString +
                '}';
    }
}
