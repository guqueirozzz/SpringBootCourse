package com.estudosjava.springbootcourse.services;


import com.estudosjava.springbootcourse.entities.Payment;
import com.estudosjava.springbootcourse.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {

        return paymentRepository.findAll();
    }
}
