package ru.kmetha.gblesson10rest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kmetha.gblesson10rest.entity.Order;
import ru.kmetha.gblesson10rest.service.OrderService;
import ru.kmetha.gblesson10rest.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/management")
public class OrderProductRestController {

    private final ProductService productService;
    private final OrderService orderService;

    @GetMapping("/{orderId}/add/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String addProductInCart(@PathVariable("orderId") Long cartId, @PathVariable("productId") Long productId) {
        if (productId != null && cartId != null) {
            Order order = orderService.findById(cartId);
            order.addProduct(productService.findById(productId));
            orderService.save(order);
            return "Success";
        }
        return "Failed";
    }

    @DeleteMapping("/{orderId}/delete/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteById(@PathVariable("orderId") Long cartId, @PathVariable("productId") Long productId) {
        if (productId != null && cartId != null) {
            Order order = orderService.findById(cartId);
            order.deleteProduct(productService.findById(productId));
            orderService.save(order);
            return "Success";
        }
        return "Failed";
    }
}
