package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.HotelServiceReadDto;
import pl.senla.hotel.dto.OrderReadDto;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OrderReadDtoMapperUtil {

    private OrderReadDtoMapperUtil() {}

    public static OrderReadDto convertOrderToOrderDtoRead(Order order, List<HotelService> hotelServices) {
        log.debug("Start: convert Order to OrderDto");
        Integer idGuest = order.getGuest().getIdGuest();
        return new OrderReadDto(idGuest,
                HotelServiceReadDtoMapperUtil.convertListHotelServiceToHotelServiceDto(hotelServices));
    }

    public static List<OrderReadDto> convertListOrderToOrderDtoRead(List<Order> orders, List<HotelService> hotelServices) {
        log.debug("Start: convert Order to OrderDto");
        List<OrderReadDto> orderReadDtoList = new ArrayList<>();
        for (Order order : orders) {
            Integer idOrder = order.getIdOrder();
            if (idOrder != null) {
                List<HotelServiceReadDto> hotelServiceReadDtoList = hotelServices.stream()
                        .filter(hs -> hs.getOrder().getIdOrder().equals(idOrder))
                        .map(HotelServiceReadDtoMapperUtil::convertHotelServiceToHotelServiceDto)
                        .toList();
                OrderReadDto orderReadDto = new OrderReadDto(idOrder, hotelServiceReadDtoList);
                orderReadDtoList.add(orderReadDto);
            }
            return orderReadDtoList;
            }
        return null;
    }
}
