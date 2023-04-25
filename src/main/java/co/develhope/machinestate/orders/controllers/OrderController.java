package co.develhope.machinestate.orders.controllers;

import co.develhope.machinestate.orders.entities.Order;
import co.develhope.machinestate.orders.repositories.OrderRepository;
import co.develhope.machinestate.orders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/{id}")
    public ResponseEntity<Order> create(@RequestBody Order order){
        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getSingle(@PathVariable Long id){
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(order.get());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll(){
        return ResponseEntity.ok(orderRepository.findAll());
    }


}
