package com.nexign.coffeeShop.db;

import com.nexign.coffeeShop.domain.utils.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {
    private static final String URL = PropertiesUtil.get("db.url");
    private static final String USER = PropertiesUtil.get("db.username");
    private static final String PASSWORD = PropertiesUtil.get("db.password");

    private static final int INITIAL_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 100;

    private final Queue<Connection> connectionPool = new ConcurrentLinkedQueue<>();
    private final Semaphore semaphore = new Semaphore(MAX_POOL_SIZE, true);
    private int currentPoolSize = 0;

    private static ConnectionPool instance;

    private ConnectionPool() {
        try {
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                connectionPool.add(createConnection());
                currentPoolSize++;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing Connection Pool", e);
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    public Connection getConnection() {
        try {
            semaphore.acquire();
            Connection connection = connectionPool.poll();
            if (connection == null) {
                synchronized (this) {
                    if (currentPoolSize < MAX_POOL_SIZE) {
                        connection = createConnection();
                        currentPoolSize++;
                    }
                }
            }
            return (connection != null && isValid(connection)) ? connection : createConnection();
        } catch (InterruptedException | SQLException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error acquiring connection", e);
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.offer(connection);
            semaphore.release();
        }
    }
    private boolean isValid(Connection connection) {
        try {
            return !connection.isClosed() && connection.isValid(2);
        } catch (SQLException e) {
            return false;
        }
    }
    public void closeAllConnections() {
        for (Connection connection : connectionPool) {
            try {
                connection.close();
            } catch (SQLException e) {
                Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, "Error closing connection", e);
            }
        }
        connectionPool.clear();
    }
}
