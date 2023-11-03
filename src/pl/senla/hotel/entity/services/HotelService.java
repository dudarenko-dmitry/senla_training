package pl.senla.hotel.entity.services;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

import static pl.senla.hotel.constant.HotelServiceConstant.*;
import static pl.senla.hotel.constant.OrderConstant.ERROR_READ_ORDER;

@Setter
@Getter
public abstract class HotelService implements Serializable {

    @Serial
    private static final long serialVersionUID = 20L;

    protected Integer idService;
    protected Integer idOrder;
    protected TypeOfService typeOfService;
    protected Integer idGuest;

    protected HotelService() {
    }

    protected HotelService(Integer idService, Integer idOrder, TypeOfService typeOfService, Integer idGuest) {
        if(idOrder == null) {
            System.out.println(ERROR_READ_ORDER);
            return;
        }
        if (idGuest == null) {
            System.out.println(ERROR_NULL_GUEST);
            return;
        }
        this.idService = idService;
        this.idGuest = idGuest;
        this.typeOfService = typeOfService;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        if (idService != null) {
            this.idService = idService;
        } else {
            System.out.println(ERROR_NULL_ID);
        }
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        if (idOrder != null) {
            this.idOrder = idOrder;
        } else {
            System.out.println(ERROR_NULL_ID_ORDER);
        }

    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(TypeOfService typeOfService) {
        if (typeOfService != null) {
            this.typeOfService = typeOfService;
        } else {
            System.out.println(ERROR_NULL_CATEGORY);
        }
    }

    public Integer getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Integer idGuest) {
        if (idGuest != null) {
            this.idGuest = idGuest;
        } else {
            System.out.println(ERROR_NULL_GUEST);
        }
    }

    @Override
    public String toString() {
        return "{typeOfService='" + typeOfService +
                ", idGuest=" + idGuest +
                '}';
    }
}
