package ru.kmetha.gblesson10rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kmetha.gblesson10rest.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
