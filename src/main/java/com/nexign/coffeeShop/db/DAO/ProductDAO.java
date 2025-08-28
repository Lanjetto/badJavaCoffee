package com.nexign.coffeeShop.db.DAO;

import com.nexign.coffeeShop.db.ConnectionManager;
import com.nexign.coffeeShop.db.ConnectionPool;
import com.nexign.coffeeShop.domain.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ProductDAO {
    //private ConnectionManager connectionManager;
    private ConnectionPool connectionManager;

    public ProductDAO(ConnectionPool connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Optional<Product> getProductByName(String name) throws SQLException {
        String sql = """
                SELECT id, name, price, type 
                FROM products WHERE name = ?;
                """;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name must not be null or empty");
        }
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

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
