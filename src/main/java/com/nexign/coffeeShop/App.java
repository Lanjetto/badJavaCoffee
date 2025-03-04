package com.nexign.coffeeShop;


import com.nexign.coffeeShop.db.ConnectionManager;
import com.nexign.coffeeShop.db.DAO.OrderDAO;
import com.nexign.coffeeShop.db.DAO.ProductDAO;
import com.nexign.coffeeShop.repository.JDBCOrderRepository;
import com.nexign.coffeeShop.repository.JDBCProductRepository;
import com.nexign.coffeeShop.services.OrderService;
import com.nexign.coffeeShop.socket.server.HttpServer;

public class App {
    public static void main(String[] args) {
        var productRepo = new JDBCProductRepository(new ProductDAO(ConnectionManager.getInstance()));
        var orderRepo = new JDBCOrderRepository(new OrderDAO(ConnectionManager.getInstance()));
        var orderService = new OrderService(productRepo, orderRepo);

        var httpServer = new HttpServer(7777, orderService);
        httpServer.run();
    }
}
