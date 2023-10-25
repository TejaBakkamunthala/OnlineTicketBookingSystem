package com.ticket.app.service;

import java.util.List;

import com.ticket.app.entity.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPayments();
    void deletePayment(Long paymentId);
    // Add more methods as needed
}
