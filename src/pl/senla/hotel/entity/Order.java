package pl.senla.hotel.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static pl.senla.hotel.constant.OrderConstant.*;

@Setter
@Getter
public class Order implements Serializable {

    private Integer idOrder;
    private Integer idGuest;
    private List<Integer> idServices = new ArrayList<>();

    @Serial
    private static final long serialVersionUID = 31L;

    public Order(Integer idGuest) {
        this.idOrder = idGuest;
    }

    public Order(Integer idGuest, List<Integer> idServices) {
        if (idGuest == null) {
            System.out.println(ERROR_CREATE_ORDER_NO_CLIENT);
            return;
        }
        this.idGuest = idGuest;
        this.idServices = idServices;
    }

    public Order() {

    }

    public void setIdGuest(Integer idGuest) {
        if (idGuest != null) {
            this.idGuest = idGuest;
        } else {
            System.out.println(ERROR_ID_GUEST);
        }

    }

    public void setServices(List<Integer> idServices) {
        if (idServices != null) {
            this.idServices = idServices;
        } else {
            System.out.println(ERROR_ID_SERVICES);
        }
    }

    @Override
    public String toString() {
        return "\n=== > Order{" +
                "idOrder=" + idOrder +
                ", idGuest= " + idGuest +
                ", idServices= " + idServices +
                '}';
    }
}
