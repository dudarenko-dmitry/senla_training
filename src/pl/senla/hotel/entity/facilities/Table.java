package pl.senla.hotel.entity.facilities;

import java.io.Serial;
import java.io.Serializable;

public class Table extends HotelFacility implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    public Table(String category, String nameFacility, int price, int capacity) {
        super(category, nameFacility, price, capacity);
    }

    @Override
    public String toString() {
        return "\nTable{" +
                "tableId=" + super.getIdFacility() +
                ", category=" + super.getCategory() +
                ", tableNumber=" + super.getNameFacility() +
                ", tablePrice=" + super.getPrice() +
                ", capacity=" + super.getCapacity() +  '\'' +
                '}';
    }
}
