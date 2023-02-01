package com.estudosjava.springbootcourse.repositories;

import com.estudosjava.springbootcourse.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // opcional porque o JPARepository ja faz isso
public interface OrderRepository extends JpaRepository<Order, Long> {

}
