package pl.senla.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HotelServiceNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(HotelServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String hotelServiceNotFoundHandler(HotelServiceNotFoundException exception) {
        return exception.getMessage();
    }
}
