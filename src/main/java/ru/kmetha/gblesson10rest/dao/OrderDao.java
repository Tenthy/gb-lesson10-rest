package ru.kmetha.gblesson10rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kmetha.gblesson10rest.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}
