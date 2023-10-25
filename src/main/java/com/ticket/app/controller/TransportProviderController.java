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

import com.ticket.app.entity.TransportProvider;
import com.ticket.app.service.TransportProviderService;

@RestController
@RequestMapping("/transport-providers")
public class TransportProviderController {

    @Autowired
    private TransportProviderService transportProviderService;

    @PostMapping
    public ResponseEntity<TransportProvider> createTransportProvider(@RequestBody TransportProvider provider) {
        TransportProvider newProvider = transportProviderService.createTransportProvider(provider);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProvider);
    }

    @GetMapping("/{providerId}")
    public ResponseEntity<TransportProvider> getTransportProviderById(@PathVariable Long providerId) {
        TransportProvider provider = transportProviderService.getTransportProviderById(providerId);
        if (provider != null) {
            return ResponseEntity.ok(provider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TransportProvider>> getAllTransportProviders() {
        List<TransportProvider> providers = transportProviderService.getAllTransportProviders();
        return ResponseEntity.ok(providers);
    }

    @DeleteMapping("/{providerId}")
    public ResponseEntity<Void> deleteTransportProvider(@PathVariable Long providerId) {
        transportProviderService.deleteTransportProvider(providerId);
        return ResponseEntity.noContent().build();
    }

    // Add more endpoints as needed
}
