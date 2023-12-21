package pl.senla.hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class GuestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 112L;

    private String name;
    private Integer phoneNumber;

}
