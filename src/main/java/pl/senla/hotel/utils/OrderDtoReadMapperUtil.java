package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.OrderDtoRead;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.service.ServiceGuest;
import pl.senla.hotel.service.ServiceHotelService;
import pl.senla.hotel.service.ServiceOrder;

import java.util.List;

@Component
@Slf4j
public class OrderDtoReadMapperUtil {

    private OrderDtoReadMapperUtil() {}

    @Autowired
    private static ServiceOrder serviceOrder;
    @Autowired
    private static ServiceGuest serviceGuest;
    @Autowired
    private static ServiceHotelService serviceHotelService;

    public static OrderDtoRead convertOrderToOrderDtoRead(Order order) {
        log.debug("Start: convert Order to OrderDto");
        int idOrder = order.getIdOrder();
        List<HotelService> hotelServices = serviceHotelService.readAll().stream()
                .filter(hotelService -> hotelService.getOrder().getIdOrder() == idOrder)
                .toList();
        return new OrderDtoRead(idOrder, hotelServices);
    }

}
