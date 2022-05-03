package ru.kmetha.gblesson10rest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kmetha.gblesson10rest.entity.Product;
import ru.kmetha.gblesson10rest.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAll();
    }
}
