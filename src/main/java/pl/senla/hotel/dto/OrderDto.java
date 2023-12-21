package pl.senla.hotel.dto;

import lombok.Builder;
import lombok.Data;
import pl.senla.hotel.entity.Guest;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class OrderDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 32L;

    private Integer idOrder;
    private Integer idGuest;

    private Guest guest;

}
