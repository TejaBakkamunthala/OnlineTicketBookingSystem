package com.ticket.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ticket.app.entity.TransportMode;

@Repository
public interface TransportModeRepository extends JpaRepository<TransportMode, Long>, JpaSpecificationExecutor<TransportMode> {
    // Add custom query methods if needed
}
