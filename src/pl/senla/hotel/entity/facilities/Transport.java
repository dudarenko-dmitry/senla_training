package pl.senla.hotel.entity.facilities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class Transport extends HotelFacility implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

    public Transport(CategoryFacility category, String nameFacility, Integer price, Integer capacity) {
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
