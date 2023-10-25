package com.ticket.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.app.entity.PaymentMethod;
import com.ticket.app.repository.PaymentMethodRepository;
import com.ticket.app.service.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod getPaymentMethodById(Long paymentMethodId) {
        return paymentMethodRepository.findById(paymentMethodId).orElse(null);
    }

    @Override
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public void deletePaymentMethod(Long paymentMethodId) {
        paymentMethodRepository.deleteById(paymentMethodId);
    }

    // Add more methods as needed
}
