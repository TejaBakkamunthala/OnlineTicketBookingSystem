package com.ticket.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.app.entity.TransportProvider;
import com.ticket.app.repository.TransportProviderRepository;
import com.ticket.app.service.TransportProviderService;

@Service
public class TransportProviderServiceImpl implements TransportProviderService {

    @Autowired
    private TransportProviderRepository transportProviderRepository;

    @Override
    public TransportProvider createTransportProvider(TransportProvider provider) {
        return transportProviderRepository.save(provider);
    }

    @Override
    public TransportProvider getTransportProviderById(Long providerId) {
        return transportProviderRepository.findById(providerId).orElse(null);
    }

    @Override
    public List<TransportProvider> getAllTransportProviders() {
        return transportProviderRepository.findAll();
    }

    @Override
    public void deleteTransportProvider(Long providerId) {
        transportProviderRepository.deleteById(providerId);
    }

    // Add more methods as needed
}
