package com.app.product.service;

import com.app.product.entities.Order;
import com.app.product.entities.Product;
import com.app.product.repository.OrderRepository;
import com.app.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public Order placeOrder(Order order) {
        Order orderToSave = new Order();
        orderToSave.setBuyerEmail(order.getBuyerEmail());
        orderToSave.setOrderedTime(LocalDate.now());
        orderToSave.setProducts(order.getProducts());
        orderToSave.setTotalPrice(calculateProductPrice(order.getProducts()));
        return orderRepository.save(orderToSave);
    }

    private Double calculateProductPrice(String products) {
        List<String> productList = Arrays.asList(products.split(","));

        List<Product> orderedProducts = new ArrayList<>();
        productList.forEach(product -> {
            orderedProducts.add(productRepository.findByName(product.toUpperCase()));
        });

        return orderedProducts.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public List<Order> getOrders(String startDate, String endDate) {
        return orderRepository.findByOrderedTimeBetween(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}
