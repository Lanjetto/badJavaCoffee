package com.nexign.coffeeShop.db.DAO;

import com.nexign.coffeeShop.db.ConnectionManager;
import com.nexign.coffeeShop.domain.order.Order;
import com.nexign.coffeeShop.domain.order.OrderItem;

import java.sql.*;

public class OrderDAO {
    private ConnectionManager connectionManager;

    public OrderDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void saveOrderWithItems(Order order) throws SQLException {
        String orderSql = "INSERT INTO orders (total_price) VALUES (?) RETURNING id";
        String itemSql = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";

        try (var connection = connectionManager.getConnection()) {
            connection.setAutoCommit(false);

            try (var orderStatement = connection.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS)) {
                orderStatement.setDouble(1, order.getTotalPrice());
                orderStatement.executeUpdate();

                var generatedKeys = orderStatement.getGeneratedKeys();
                if (!generatedKeys.next()) {
                    throw new SQLException("Failed to get generated key");
                }

                var orderId = generatedKeys.getLong(1);

                try (var itemStatement = connection.prepareStatement(itemSql)) {
                    for (OrderItem item : order.getOrderItems()) {
                        itemStatement.setLong(1, orderId);
                        itemStatement.setLong(2, item.getProduct().getId());
                        itemStatement.setInt(3, item.getQuantity());
                        itemStatement.addBatch();
                    }
                    itemStatement.executeBatch();
                }
                connection.commit();

            } catch (SQLException e) {
                connection.rollback();
                throw e;
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }
}
