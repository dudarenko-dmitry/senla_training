package pl.senla.hotel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;

import static pl.senla.hotel.constant.OrderConstant.*;

@Setter
@Getter
@Slf4j
public class OrderDto implements Serializable {

    private Integer idOrder;
    private Integer idGuest;

    @Serial
    private static final long serialVersionUID = 32L;

    public OrderDto(Integer idGuest) {
        this.idOrder = idGuest;
    }

    public OrderDto() {

    }

    public void setIdOrder(Integer idOrder) {
        if (idOrder != null) {
            this.idOrder = idOrder;
        } else {
            log.warn(ERROR_ID_ORDER);
        }
    }

    public void setIdGuest(Integer idGuest) {
        if (idGuest != null) {
            this.idGuest = idGuest;
        } else {
            log.warn(ERROR_ID_GUEST);
        }
    }

    @Override
    public String toString() {
        return "\n=== > Order{" +
                "idOrder=" + idOrder +
                ", idGuest= " + idGuest +
                '}';
    }
}