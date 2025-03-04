package com.nexign.coffeeShop;


import com.nexign.coffeeShop.db.ConnectionPool;
import com.nexign.coffeeShop.db.DAO.OrderDAO;
import com.nexign.coffeeShop.db.DAO.ProductDAO;
import com.nexign.coffeeShop.repository.JDBCOrderRepository;
import com.nexign.coffeeShop.repository.JDBCProductRepository;
import com.nexign.coffeeShop.services.OrderService;
import com.nexign.coffeeShop.socket.server.HttpServerExecutors;
import com.nexign.coffeeShop.socket.server.RequestHandler;

public class App {
    public static void main(String[] args) {

        var pool = ConnectionPool.getInstance();
        var productRepo = new JDBCProductRepository(new ProductDAO(pool));
        var orderRepo = new JDBCOrderRepository(new OrderDAO(pool));

        var order = new OrderService(productRepo, orderRepo);

        var requestHandler = new RequestHandler(order);
        var httpServer = new HttpServerExecutors(7777, requestHandler);
        httpServer.run();
    }
}
