package com.ticket.app.service;

import java.util.List;

import com.ticket.app.entity.Route;

public interface RouteService {
    Route createRoute(Route route);
    Route getRouteById(Long routeId);
    List<Route> getAllRoutes();
    void deleteRoute(Long routeId);
    // Add more methods as needed
}
