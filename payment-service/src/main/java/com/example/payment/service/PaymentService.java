package com.example.payment.service;

import com.example.payment.model.Payment;
import com.example.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository repo;
    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public Payment save(Payment p) { return repo.save(p); }
    public List<Payment> all() { return repo.findAll(); }
}
