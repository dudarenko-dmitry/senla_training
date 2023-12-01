package pl.senla.hotel.entity.facilities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "rooms")
public class Room implements Serializable {

    @Id
    @Column(name = "facilityID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacility;

    @Column(name = "category", nullable = false)
    private CategoryFacility category;

    @Column(name = "nameFacility", nullable = false)
    private String nameFacility;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "level", nullable = false)
    private RoomLevel roomLevel;

    @Column(name = "status", nullable = false)
    private RoomStatus roomStatus;

    @Serial
    private static final long serialVersionUID = 4L;

    public Room(CategoryFacility category, String nameFacility, Integer price,
                Integer capacity, RoomLevel roomLevel, RoomStatus roomStatus) {
        this.category = category;
        this.nameFacility = nameFacility;
        this.price = price;
        this.capacity = capacity;
        this.roomLevel = roomLevel;
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
