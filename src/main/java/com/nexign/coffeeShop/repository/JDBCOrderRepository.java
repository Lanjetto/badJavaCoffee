package com.nexign.coffeeShop.repository;

import com.nexign.coffeeShop.db.DAO.OrderDAO;
import com.nexign.coffeeShop.domain.order.Order;

import java.sql.SQLException;

public class JDBCOrderRepository implements OrderRepository {
    private OrderDAO orderDAO;

    public JDBCOrderRepository(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void save(Order order) {
        try {
            orderDAO.saveOrderWithItems(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
