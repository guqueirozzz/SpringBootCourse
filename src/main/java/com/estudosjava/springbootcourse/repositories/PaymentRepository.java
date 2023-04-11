package com.estudosjava.springbootcourse.repositories;

import com.estudosjava.springbootcourse.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
