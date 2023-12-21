package pl.senla.hotel.exceptions;

public class OrderNotFoundException extends RuntimeException {

    OrderNotFoundException(Integer idOrder) {
        super("Could not find Order " + idOrder);
    }
}
