package pl.senla.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 132L;

    private Integer idGuest;

}
