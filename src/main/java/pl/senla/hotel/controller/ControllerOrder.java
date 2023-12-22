package pl.senla.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import pl.senla.hotel.dto.OrderDto;
import pl.senla.hotel.dto.OrderDtoRead;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ControllerOrder extends ControllerCRUDALL<OrderDto> {

    @GetMapping("/")
    List<OrderDtoRead> readAllWithServices();

    OrderDtoRead readWithServices(int idOrder) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException;
}
