package com.app.product.repository;

import com.app.product.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findByOrderedTimeBetween(LocalDate startDate, LocalDate endDate);
}
