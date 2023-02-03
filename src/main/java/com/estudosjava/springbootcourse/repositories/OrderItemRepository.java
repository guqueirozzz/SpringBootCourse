package com.estudosjava.springbootcourse.repositories;

import com.estudosjava.springbootcourse.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
