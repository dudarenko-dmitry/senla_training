package pl.senla.hotel.entity.facilities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

import static pl.senla.hotel.constant.HotelFacilityConstant.*;

@Setter
@Getter
public class HotelFacility implements Serializable {

    private Integer idFacility;
    private CategoryFacility category;
    private String nameFacility;
    private Integer price;
    private Integer capacity;

    @Serial
    private static final long serialVersionUID = 4L;

    public HotelFacility(CategoryFacility category, String nameFacility, Integer price, Integer capacity) {
        this.category = category;
        this.nameFacility = nameFacility;
        this.price = price;
        this.capacity = capacity;
    }

    public HotelFacility() {

    }

    public void setIdFacility(Integer idFacility) {
        if (idFacility != null) {
            this.idFacility = idFacility;
        } else {
            System.out.println(ERROR_NULL_ID);
        }
    }

    public void setCategory(CategoryFacility category) {
        if (category != null) {
            this.category = category;
        } else {
            System.out.println(ERROR_NULL_CATEGORY);
        }
    }

    public void setNameFacility(String nameFacility) {
        if (nameFacility != null) {
            this.nameFacility = nameFacility;
        } else {
            System.out.println(ERROR_NAME_FACILITY);
        }
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (price != null) {
            this.price = price;
        } else {
            System.out.println(ERROR_NULL_PRICE);
        }
    }

    public void setCapacity(Integer capacity) {
        if (capacity != null) {
            this.capacity = capacity;
        } else {
            System.out.println(ERROR_NULL_CAPACITY);
        }
    }

    @Override
    public String toString() {
        return "\nHotelFacility{" +
                "idFacility=" + idFacility +
                ", category='" + category + '\'' +
                ", nameFacility=" + nameFacility +
                ", price=" + price +
                ", capacity=" + capacity +
                '}';
    }
}
