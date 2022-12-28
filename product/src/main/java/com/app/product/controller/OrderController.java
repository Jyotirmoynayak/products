package com.app.product.controller;

import com.app.product.entities.Order;
import com.app.product.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }

    @GetMapping
    public List<Order> getOrders(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return orderService.getOrders(startDate, endDate);
    }
}
