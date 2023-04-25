package co.develhope.machinestate.orders.services;

import co.develhope.machinestate.orders.entities.Order;
import co.develhope.machinestate.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return order;
    }
}
