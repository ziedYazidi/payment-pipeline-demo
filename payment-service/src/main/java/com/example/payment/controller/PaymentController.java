package com.example.payment.controller;

import com.example.payment.model.Payment;
import com.example.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public Payment create(@RequestBody Payment p) { return service.save(p); }

    @GetMapping
    public List<Payment> all() { return service.all(); }
}
