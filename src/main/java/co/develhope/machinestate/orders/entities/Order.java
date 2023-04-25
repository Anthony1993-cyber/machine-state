package co.develhope.machinestate.orders.entities;

import co.develhope.machinestate.users.entities.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;
    private String address;
    private String number;
    private String city;
    private String zipCode;
    private String state;
    private double totalPrice;
    private OrderStatusEnum status;
    @ManyToOne
    private User restaurant;
    @ManyToOne
    private User rider;
}
