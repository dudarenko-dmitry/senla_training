package pl.senla.hotel.entity.facilities;

public class Transport extends HotelFacility{

    public Transport(int idFacility, String category, String nameFacility, int price, int capacity) {
        super(idFacility, category, nameFacility, price, capacity);
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
