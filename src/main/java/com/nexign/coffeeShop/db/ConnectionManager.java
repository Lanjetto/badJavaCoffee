package com.nexign.coffeeShop.db;

import com.nexign.coffeeShop.domain.utils.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    private static final String URL = PropertiesUtil.get("db.url");
    private static final String USER = PropertiesUtil.get("db.username");
    private static final String PASSWORD = PropertiesUtil.get("db.password");

    private static ConnectionManager instance;

    private ConnectionManager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);

//        String createSql = """
//                CREATE TABLE if not exist products (
//                    id SERIAL PRIMARY KEY,
//                    name VARCHAR(255) NOT NULL UNIQUE,
//                    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
//                    type VARCHAR(50) NOT NULL
//                );
//                """;
//        String insertSql = """
//                INSERT INTO products (name, price, type) VALUES
//                    ('Espresso', 80, 'coffee'),
//                    ('Cappuccino', 100, 'coffee'),
//                    ('Latte', 120, 'coffee'),
//                    ('Pie', 100, 'food'),
//
//        """;

//        try (var connection = DriverManager.getConnection(URL, USER, PASSWORD);
//             var statement = connection.prepareStatement(createSql);) {
//            statement.execute();

        }
    }
//
//    public static void main(String[] args) throws SQLException {
//        ConnectionManager.getConnection();
//    }


