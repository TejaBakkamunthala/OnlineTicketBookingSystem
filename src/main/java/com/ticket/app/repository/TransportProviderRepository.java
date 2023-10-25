package com.ticket.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ticket.app.entity.TransportProvider;

@Repository
public interface TransportProviderRepository extends JpaRepository<TransportProvider, Long>, JpaSpecificationExecutor<TransportProvider> {
    // Add custom query methods if needed
}
