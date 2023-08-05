package pl.senla.hotel.entity.facilities;

import java.io.Serial;
import java.io.Serializable;

public class Transport extends HotelFacility implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

    public Transport(String category, String nameFacility, int price, int capacity) {
        super(category, nameFacility, price, capacity);
    }

    @Override
    public String toString() {
        return "\nTransport{" +
                "transportId=" + super.getIdFacility() +
                ", category=" + super.getCategory() +
                ", transportRoute" + super.getNameFacility() +
                ", transportPrice=" + super.getPrice() +
                ", capacity=" + super.getCapacity() +  '\'' +
                '}';
    }
}
