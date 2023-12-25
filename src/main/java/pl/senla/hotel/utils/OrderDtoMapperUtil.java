package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.OrderDto;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.service.ServiceGuest;
import pl.senla.hotel.service.ServiceOrder;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Component
@Slf4j
public class OrderDtoMapperUtil {

    private OrderDtoMapperUtil() {}

    @Autowired
    private static ServiceOrder serviceOrder;
    @Autowired
    private static ServiceGuest serviceGuest;

    public static Order convertGuestDtoToGuest(OrderDto orderDto) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("Start: convert OrderDto to Order");
        Order order = new Order();
        Order orderFromDB = serviceOrder.readAll().stream()
                .filter(o -> Objects.equals(o.getGuest().getIdGuest(), orderDto.getIdGuest()))
                .findAny().orElse(null);
        Integer idOrder = 0;
        if (orderFromDB != null) {
            idOrder = orderFromDB.getIdOrder();
        }
        Guest guest = serviceGuest.read(orderDto.getIdGuest());
        order.setIdOrder(idOrder);
        order.setGuest(guest);
        return order;
    }

    public static OrderDto convertOrderToOrderDto(Order order) {
        log.debug("Start: convert Order to OrderDto");
        return new OrderDto(order.getGuest().getIdGuest());
    }

}
