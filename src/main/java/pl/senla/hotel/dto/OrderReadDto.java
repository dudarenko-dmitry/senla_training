package pl.senla.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderReadDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 132L;

    private Integer idGuest;
    private List<HotelServiceReadDto> hotelServices;

    @Override
    public String toString() {
        return "OrderDtoRead{" +
                "idGuest=" + idGuest +
                "\nhotelServices=" + hotelServices.stream().peek(System.out::println).toList() +
                '}';
    }
}
