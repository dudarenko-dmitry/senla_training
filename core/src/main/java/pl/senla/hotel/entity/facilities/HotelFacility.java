package pl.senla.hotel.entity.facilities;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;

import static pl.senla.hotel.constant.HotelFacilityConstant.*;

@Setter
@Getter
@Slf4j
public class HotelFacility implements Serializable {

    private Integer idFacility;
    private CategoryFacility category;
    private String nameFacility;
    private Integer price;
    private Integer capacity;
    private RoomLevel roomLevel;
    private RoomStatus roomStatus;

    @Serial
    private static final long serialVersionUID = 4L;

    public HotelFacility() {

    }

    public HotelFacility(CategoryFacility category, String nameFacility, Integer price,
                         Integer capacity, RoomLevel roomLevel, RoomStatus roomStatus) {
        this.category = category;
        this.nameFacility = nameFacility;
        this.price = price;
        this.capacity = capacity;
        this.roomLevel = roomLevel;
        this.roomStatus = roomStatus;
    }

    public void setCategory(CategoryFacility category) {
        if (category != null) {
            this.category = category;
        } else {
            log.warn(ERROR_NULL_CATEGORY);
        }
    }

    public void setNameFacility(String nameFacility) {
        if (nameFacility != null) {
            this.nameFacility = nameFacility;
        } else {
            log.warn(ERROR_NAME_FACILITY);
        }
    }

    public void setPrice(Integer price) {
        if (price != null) {
            this.price = price;
        } else {
            log.warn(ERROR_NULL_PRICE);
        }
    }

    public void setCapacity(Integer capacity) {
        if (capacity != null) {
            this.capacity = capacity;
        } else {
            log.warn(ERROR_NULL_CAPACITY);
        }
    }

    public void setRoomLevel(RoomLevel roomLevel) {
        this.roomLevel = roomLevel;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void makeRoomAvailable() {
        roomStatus = RoomStatus.AVAILABLE;
    }

    public void makeRoomRepaired() {
        roomStatus = RoomStatus.REPAIRED;
    }

    @Override
    public String toString() {
        return "\nHotelFacility{" +
                "idFacility=" + idFacility +
                ", category='" + category + '\'' +
                ", nameFacility=" + nameFacility +
                ", price=" + price +
                ", capacity=" + capacity +
                ", roomLevel=" + roomLevel +
                ", roomStatus=" + roomStatus +
                '}';
    }
}
