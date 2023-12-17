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
import java.util.ArrayList;
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
    public List<OrderReadDto> readAll() {
        log.debug("ControllerOrder call ServiceOrder's method 'readAll'.");
        return OrderReadDtoMapperUtil
                .convertListOrderToOrderDtoRead(orderService.readAll(), serviceRoomReservation.readAll());
    }

    @Override
    @PostMapping("/")
    public OrderReadDto create(@RequestBody OrderCreateDto orderCreateDto) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        log.debug("ControllerOrder call ServiceOrder's method 'create'.");
        Order order = orderService.create(orderCreateDto);
        return OrderReadDtoMapperUtil.convertOrderToOrderDtoRead(order, new ArrayList<>());
    }

    @Override
    @GetMapping("/{id}")
    public OrderReadDto read(@PathVariable Integer id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'read'.");
        log.info("USE method OrderDtoRead readWithServices()");
        Order order = orderService.read(id);
        List<HotelService> hotelServices = order.getHotelServices();
        return OrderReadDtoMapperUtil.convertOrderToOrderDtoRead(order, hotelServices);
    }

    @Override
    @PutMapping("/{id}")
    public OrderReadDto update(@PathVariable Integer id, @RequestBody OrderCreateDto orderCreateDtoNew) throws
            InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'update'.");
        Order orderUpdate = orderService.update(id, orderCreateDtoNew);
        List<HotelService> hotelServices = orderUpdate.getHotelServices();
        return OrderReadDtoMapperUtil
                .convertOrderToOrderDtoRead(orderUpdate, hotelServices);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'delete'.");
        orderService.delete(id);
    }

}
