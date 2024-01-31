package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.OrderReadDto;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;

import java.util.List;

@Component
@Slf4j
public class OrderReadDtoMapperUtil {

    private OrderReadDtoMapperUtil() {}

    public static OrderReadDto convertOrderToOrderDtoRead(Order order) {
        log.debug("Start: convert Order to OrderDto");
        Integer idGuest = order.getGuest().getIdGuest();
        List<HotelService> hotelServices = order.getHotelServices();
        return new OrderReadDto(idGuest,
                HotelServiceReadDtoMapperUtil.convertListHotelServiceToHotelServiceDto(hotelServices));
    }
}
