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
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }



    public static void main(String[] args) throws SQLException {

        String createStatement = """
            CREATE TABLE products (
                id SERIAL PRIMARY KEY,           
                name VARCHAR(255) NOT NULL,      
                price DECIMAL(10,2) NOT NULL,  
                type VARCHAR(50) NOT NULL    
            );
                        
            """;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            var statement = connection.prepareStatement(createStatement);
            statement.execute();
            System.out.println(connection.getTransactionIsolation());
        }
    }


}
