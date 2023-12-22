package pl.senla.hotel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.senla.hotel.dto.OrderDto;
import pl.senla.hotel.dto.OrderDtoRead;
import pl.senla.hotel.service.ServiceOrder;
import pl.senla.hotel.utils.OrderDtoMapperUtil;
import pl.senla.hotel.utils.OrderDtoReadMapperUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class ControllerOrderSpring implements ControllerOrder {

    @Autowired
    private ServiceOrder orderService;

    @Override
    public List<OrderDto> readAll() {
        log.debug("ControllerOrder call ServiceOrder's method 'readAll'.");
        log.info("USE method List<OrderDtoRead> readAllWithServices()");
        return orderService.readAll().stream()
                .map(OrderDtoMapperUtil::convertOrderToOrderDto)
                .toList();
    }

    @Override
    @GetMapping("/")
    public List<OrderDtoRead> readAllWithServices() {
        log.debug("ControllerOrder call ServiceOrder's method 'readAll'.");
        return orderService.readAll().stream()
                .map(OrderDtoReadMapperUtil::convertOrderToOrderDtoRead)
                .toList();
    }

    @Override
    @PostMapping("/")
    public OrderDto create(@RequestBody OrderDto orderDto) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        log.debug("ControllerOrder call ServiceOrder's method 'create'.");
        return OrderDtoMapperUtil.convertOrderToOrderDto(orderService.create(orderDto));
    }

    @Override
    public OrderDto read(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'read'.");
        log.info("USE method OrderDtoRead readWithServices()");
        return OrderDtoMapperUtil.convertOrderToOrderDto(orderService.read(id));
    }

    @Override
    @GetMapping("/{id}")
    public OrderDtoRead readWithServices(@PathVariable int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'read'.");
        log.info("USE method OrderDtoRead readWithServices()");
        return OrderDtoReadMapperUtil.convertOrderToOrderDtoRead(orderService.read(id));
    }

    @Override
    @PutMapping("/{id}")
    public OrderDto update(@PathVariable int id, @RequestBody OrderDto orderDtoNew) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'update'.");
        return OrderDtoMapperUtil.convertOrderToOrderDto(orderService.update(id, orderDtoNew));
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(int id) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        log.debug("ControllerOrder call ServiceOrder's method 'delete'.");
        orderService.delete(id);
    }

}
