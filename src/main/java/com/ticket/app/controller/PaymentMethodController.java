package com.ticket.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.app.entity.PaymentMethod;
import com.ticket.app.service.PaymentMethodService;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping
    public ResponseEntity<PaymentMethod> createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        PaymentMethod newPaymentMethod = paymentMethodService.createPaymentMethod(paymentMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaymentMethod);
    }

    @GetMapping("/{paymentMethodId}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable Long paymentMethodId) {
        PaymentMethod paymentMethod = paymentMethodService.getPaymentMethodById(paymentMethodId);
        if (paymentMethod != null) {
            return ResponseEntity.ok(paymentMethod);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllPaymentMethods();
        return ResponseEntity.ok(paymentMethods);
    }

    @DeleteMapping("/{paymentMethodId}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long paymentMethodId) {
        paymentMethodService.deletePaymentMethod(paymentMethodId);
        return ResponseEntity.noContent().build();
    }

    // Add more endpoints as needed
}
