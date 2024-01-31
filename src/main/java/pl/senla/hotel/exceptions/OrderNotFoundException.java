package pl.senla.hotel.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Integer idOrder) {
        super("Could not find Order " + idOrder);
    }
}
