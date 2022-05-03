package ru.kmetha.gblesson10rest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kmetha.gblesson10rest.entity.Order;
import ru.kmetha.gblesson10rest.service.OrderService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable("orderId") Long id) {
        Order order;
        if (id != null) {
            order = orderService.findById(id);
            if (order != null) {
                return new ResponseEntity<>(order, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@Validated @RequestBody Order order) {
        Order savedOrder = orderService.save(order);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/api/v1/order/" + savedOrder.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("orderId") Long id) {
        orderService.deleteById(id);
    }
}
