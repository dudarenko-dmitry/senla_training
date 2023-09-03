package pl.senla.hotel.entity;

import java.io.Serial;
import java.io.Serializable;

import static pl.senla.hotel.constant.ReaderConstant.*;

public class CsvOrder implements Serializable {

    private Integer idOrder;
    private Integer idGuest;
    private String idServices;

    @Serial
    private static final long serialVersionUID = 30L;

    public CsvOrder() {

    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        if (idOrder != null) {
            this.idOrder = idOrder;
        } else {
            System.out.println(ERROR_READER_ID_ORDER);
        }
    }

    public Integer getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Integer idGuest) {
        if (idGuest != null) {
            this.idGuest = idGuest;
        } else {
            System.out.println(ERROR_READER_ID_GUEST);
        }
    }

    public String getServices() {
        return idServices;
    }


    public void setServices(String idServices) {
        if (idServices != null) {
            this.idServices = idServices;
        } else {
            System.out.println(ERROR_READER_ID_SERVICES);
        }
    }

    @Override
    public String toString() {
        return "\n=== > CsvOrder{" +
                "idOrder=" + idOrder +
                ", idGuest= " + idGuest +
                ", idServices= " + idServices +
                '}';
    }
}
