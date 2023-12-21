package pl.senla.hotel.entity.facilities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
@Slf4j
@Entity
@Table(name = "rooms")
public class Room implements Serializable {

    @Id
    @Column(name = "facilityID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoom;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private CategoryFacility category;

    @Column(name = "name_facility", nullable = false)
    private String nameFacility;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private RoomLevel roomLevel;

    @Enumerated(EnumType.STRING)
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
                "idFacility=" + idRoom +
                ", category='" + category + '\'' +
                ", nameFacility=" + nameFacility +
                ", price=" + price +
                ", capacity=" + capacity +
                ", roomLevel=" + roomLevel +
                ", roomStatus=" + roomStatus +
                '}';
    }
}
