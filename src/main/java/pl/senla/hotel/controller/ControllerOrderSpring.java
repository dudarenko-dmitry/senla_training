package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.senla.hotel.dto.OrderCreateDto;
import pl.senla.hotel.dto.OrderReadDto;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.service.ServiceOrder;
import pl.senla.hotel.service.ServiceRoomReservation;
import pl.senla.hotel.utils.OrderReadDtoMapperUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class ControllerOrderSpring implements ControllerOrder {

    @Autowired
    private ServiceOrder orderService;
    @Autowired
    private ServiceRoomReservation serviceRoomReservation;

    @Override
    @GetMapping
    public List<OrderReadDto> readAll(
            @RequestParam(value = "sort", required = false, defaultValue = "orderID") String sortBy,
            @RequestParam(value = "guestID", required = false) String filter) {
        log.debug("ControllerOrder call ServiceOrder's method 'readAll'.");
        log.info("Orders sorted by '{}' and category '{}'", sortBy, filter);
        if(filter != null) {
            return orderService.readAll().stream()
                    .filter(o -> o.getGuest().getIdGuest().equals(Integer.parseInt(filter)))
                    .map(OrderReadDtoMapperUtil::convertOrderToOrderDtoRead)
                    .toList();
        }
        return orderService.readAll().stream()
                .map(OrderReadDtoMapperUtil::convertOrderToOrderDtoRead)
                .toList();
    }

    @Override
    @PostMapping("/")
    public OrderReadDto create(@RequestBody OrderCreateDto orderCreateDto) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        log.debug("ControllerOrder call ServiceOrder's method 'create'.");
        Order order = orderService.create(orderCreateDto);
        return OrderReadDtoMapperUtil.convertOrderToOrderDtoRead(order);
    }

    @Override
    @GetMapping("/{id}")
    public OrderReadDto read(@PathVariable Integer id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'read'.");
        log.info("USE method OrderDtoRead readWithServices()");
        Order order = orderService.read(id);
        List<HotelService> hotelServices = order.getHotelServices();
        return OrderReadDtoMapperUtil.convertOrderToOrderDtoRead(order);
    }

    @Override
    @PutMapping("/{id}")
    public OrderReadDto update(@PathVariable Integer id, @RequestBody OrderCreateDto orderCreateDtoNew) throws
            InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'update'.");
        Order orderUpdate = orderService.update(id, orderCreateDtoNew);
        List<HotelService> hotelServices = orderUpdate.getHotelServices();
        return OrderReadDtoMapperUtil
                .convertOrderToOrderDtoRead(orderUpdate);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'delete'.");
        orderService.delete(id);
    }

}
