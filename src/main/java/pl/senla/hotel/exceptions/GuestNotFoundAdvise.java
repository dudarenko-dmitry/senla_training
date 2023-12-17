package pl.senla.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GuestNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(GuestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String guestNotFoundHandler(GuestNotFoundException exception) {
        return exception.getMessage();
    }
}
