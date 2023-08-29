package pl.senla.hotel.entity.facilities;

public abstract class HotelFacility {

    private Integer idFacility;
    private CategoryFacility category;
//    private String category;
    private String nameFacility;
    private int price;
    private int capacity;

    private static final long serialVersionUID = 4L;

    protected HotelFacility(CategoryFacility category, String nameFacility, int price, int capacity) {
        this.category = category;
        this.nameFacility = nameFacility;
        this.price = price;
        this.capacity = capacity;
    }

    protected HotelFacility() {

    }

    public int getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(int idFacility) {
        this.idFacility = idFacility;
    }

    public CategoryFacility getCategory() {
        return category;
    }

    public void setCategory(CategoryFacility category) {
        this.category = category;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "HotelFacility{" +
                "idFacility=" + idFacility +
                ", category='" + category + '\'' +
                ", nameFacility=" + nameFacility +
                ", price=" + price +
                ", capacity=" + capacity +
                '}';
    }
}
