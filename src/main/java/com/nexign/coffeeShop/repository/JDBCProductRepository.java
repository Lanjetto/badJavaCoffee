package com.nexign.coffeeShop.repository;

import com.nexign.coffeeShop.db.DAO.ProductDAO;
import com.nexign.coffeeShop.domain.models.Product;

import java.sql.SQLException;
import java.util.Optional;

public class JDBCProductRepository implements ProductRepository {
    private ProductDAO productDAO;

    public JDBCProductRepository(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Optional<Product> findByName(String name) {
        try {
            return productDAO.getProductByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
