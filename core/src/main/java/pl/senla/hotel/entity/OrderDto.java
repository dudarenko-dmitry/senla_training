package pl.senla.hotel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "orders")
public class OrderDto implements Serializable {

    @Id
    @Column(name = "orderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @Column(name = "guestID", nullable = false)
    @ManyToOne
    private Integer idGuest;

    @Serial
    private static final long serialVersionUID = 32L;

    public OrderDto(Integer idGuest) {
        this.idOrder = idGuest;
    }

}
