package com.ticket.app.service;

import java.util.List;

import com.ticket.app.entity.PaymentMethod;

public interface PaymentMethodService {
    PaymentMethod createPaymentMethod(PaymentMethod paymentMethod);
    PaymentMethod getPaymentMethodById(Long paymentMethodId);
    List<PaymentMethod> getAllPaymentMethods();
    void deletePaymentMethod(Long paymentMethodId);
    // Add more methods as needed
}
