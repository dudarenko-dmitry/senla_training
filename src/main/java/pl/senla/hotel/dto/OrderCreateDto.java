package pl.senla.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 132L;

    private Integer idGuest;

}
