package ru.kmetha.gblesson10rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kmetha.gblesson10rest.dao.OrderDao;
import ru.kmetha.gblesson10rest.entity.Order;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public Order save(Order order) {
        return orderDao.save(order);
    }

    public Order findById(Long id) {
        return orderDao.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }
}
