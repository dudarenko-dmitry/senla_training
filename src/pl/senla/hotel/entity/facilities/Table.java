package pl.senla.hotel.entity.facilities;

public class Table extends HotelFacility{

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
