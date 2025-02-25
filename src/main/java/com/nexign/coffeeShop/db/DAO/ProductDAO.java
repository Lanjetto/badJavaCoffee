package com.nexign.coffeeShop.db.DAO;

import com.nexign.coffeeShop.db.ConnectionManager;
import com.nexign.coffeeShop.domain.models.Product;


import java.sql.SQLException;
import java.util.Optional;

public class ProductDAO {
    private ConnectionManager connectionManager;

    public ProductDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Optional<Product> getProductByName(String name) throws SQLException {
        String sql = "SELECT * FROM products WHERE name = ?";

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        try (var connection = connectionManager.getConnection();
             var statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("type")
                ));
            }
            return Optional.empty();
        }
    }
}
