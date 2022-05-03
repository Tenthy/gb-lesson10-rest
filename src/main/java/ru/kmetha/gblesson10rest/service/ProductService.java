package ru.kmetha.gblesson10rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kmetha.gblesson10rest.dao.ProductDao;
import ru.kmetha.gblesson10rest.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }
}
