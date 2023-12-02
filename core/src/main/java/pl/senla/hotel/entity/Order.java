package pl.senla.hotel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.entity.services.HotelService;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @Column(name = "orderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guestID")
    private Guest guest;

    @OneToMany(mappedBy = "order")
    private List<HotelService> hotelServices = new ArrayList<>();

    @Serial
    private static final long serialVersionUID = 31L;

    public Order(Integer idGuest) {
        this.idOrder = idGuest;
    }

    @Override
    public String toString() {
        return "\n=== > Order{" +
                "idOrder=" + idOrder +
                ", Guest= " + guest.getIdGuest() +
                ", Services= [read order by ID to get info]"
                +
                '}';
    }
}
