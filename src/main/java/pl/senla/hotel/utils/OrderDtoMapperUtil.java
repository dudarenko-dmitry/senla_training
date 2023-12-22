package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.OrderDto;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.ServiceGuest;
import pl.senla.hotel.service.ServiceOrder;

import java.util.Objects;

@Component
@Slf4j
public class OrderDtoMapperUtil {

    private OrderDtoMapperUtil() {}

    @Autowired
    private static ServiceOrder serviceOrder;
    @Autowired
    private static ServiceGuest serviceGuest;

    public static Order convertGuestDtoToGuest(OrderDto orderDto) {
        log.debug("Start: convert OrderDto to Order");
        return serviceOrder.readAll().stream()
                .filter(o -> Objects.equals(o.getGuest().getIdGuest(), orderDto.getIdGuest()))
                .findAny().orElse(null);
    }

    public static OrderDto convertOrderToOrderDto(Order order) {
        log.debug("Start: convert Order to OrderDto");
        return new OrderDto(order.getGuest().getIdGuest());
    }

}
