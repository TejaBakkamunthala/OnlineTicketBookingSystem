package com.ticket.app.service;

import java.util.List;

import com.ticket.app.entity.TransportProvider;

public interface TransportProviderService {
    TransportProvider createTransportProvider(TransportProvider provider);
    TransportProvider getTransportProviderById(Long providerId);
    List<TransportProvider> getAllTransportProviders();
    void deleteTransportProvider(Long providerId);
    // Add more methods as needed
}
