package com.ticket.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.app.entity.Route;
import com.ticket.app.repository.RouteRepository;
import com.ticket.app.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route getRouteById(Long routeId) {
        return routeRepository.findById(routeId).orElse(null);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public void deleteRoute(Long routeId) {
        routeRepository.deleteById(routeId);
    }

    // Add more methods as needed
}
